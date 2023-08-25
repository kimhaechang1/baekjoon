import java.util.*;
import java.io.*;
public class b16236 {
    static StringTokenizer stk;
    static int [][] map;
    static int N;
    static int time;
    static int size;
    static int count;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static  boolean [][] v;

    // 한칸에 물고기는 하나, 물고기와 아기상어는 모두 크기를 갖고있음
    // 크기는 자연수기때문에 0일 수 없음
    // 처음 아기상어의 크기는 2, 1초에 한번씩 상하좌우로 인접한 한칸씩 이동
    // 자신보다 큰 물고기 칸은 지나가기 X
    // 나머지 칸은 모드 지나갈 수 있다., 자신보다 크기가 작은 물고기만 먹을 수 있다.
    // 여기서 중요한점은 자신과 같은크기면 물고기는 먹을 수 없지만 물고기 칸은 지날 수 있다.
    // 더이상 먹을 수 있는 물고기가 없다면 엄마상어 콜
    // 먹을 수 있는 물고기가 1마리라면? 물고기 먹으러가는데 많다면 지나가는 칸의 최솟값에 있는 물고기 먹으러감
    // 그것도 여러마리면 가장 왼쪽 물고기 먹음
    // 물고기가 있는 칸으로 이동했다면 이동과 동시에 물고기를 먹음
    // 자신과 크기와 같은 수의 물고기를 먹을때마다 크기가 1씩 증가
    // 엄마 부르기전까지 물고기를 먹을 수 있는 시간을 출력
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        int sy = 0;
        int sx = 0;
        for(int i = 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 9){
                    sy= i;
                    sx =j;
                }
            }
        }
        time = 0;
        size = 2;
        count = 0;

        go();
        System.out.println(time);
    }
    static void go(){
        q : while(true){
            ArrayList<int []> list = new ArrayList<>();
            int sy = -1, sx = -1;
            for(int i=0;i<N;i++){
                for(int j = 0;j<N;j++){
                    if(map[i][j] == 9 ) {
                        sy = i;
                        sx = j;
                    }
                    else if(map[i][j] > 0 && map[i][j] < size ){
                        list.add(new int[]{i,j,map[i][j]});
                    }
                }
            }
            if(list.size() == 0) {
                break;
            } else {
                int resY = Integer.MAX_VALUE;
                int resX = Integer.MAX_VALUE;
                int minD = Integer.MAX_VALUE;
                int c = 0;

                for(int [] s : list){
                   v = new boolean[N][N];
                    int [] res = bfs(sy, sx, s[0],s[1]);
                    if(res[0] == -1 && res[1] == -1){
                        c++;
                        continue;
                    }
                    if(minD > res[0]){
                        minD = res[0];
                        resY = s[0];
                        resX = s[1];
                    }else if(minD == res[0]){
                        if(resY > s[0]){
                            resY = s[0];
                            resX = s[1];
                        }else if(resY == s[0]){
                            if(resX > s[1]){
                                resY = s[0];
                                resX = s[1];
                            }
                        }
                    }
                }
                if(c == list.size()) break q;
                if(resY == Integer.MAX_VALUE && resX == Integer.MAX_VALUE ){
                    continue;
                }
                map[sy][sx] = 0;
                map[resY][resX] = 9;
                count++;
                if(count == size) {
                    count = 0;
                    size++;
                }
                time += minD;
            }

        }
    }
    static int [] bfs(int sy, int sx, int ty, int tx){
        Queue<int []> queue = new LinkedList<>();
        int [] res = {-1,-1}; // 걸린시간, 칸 수 저장
        queue.add(new int[]{sy, sx, 0, 0});

        while(!queue.isEmpty()){
            int [] now = queue.poll();
            v[now[0]][now[1]] = true;
            if(now[0] == ty && now[1] == tx){
                res[0] = now[2];
                res[1] = now[3];
                break;
            }else{
                for(int k=0;k<4;k++){
                    int ny = now[0]+dy[k];
                    int nx = now[1]+dx[k];
                    if(ny >=N || ny < 0 || nx>=N || nx<0 || v[ny][nx] || map[ny][nx] > size) continue;
                    v[ny][nx] = true;
                    queue.add(new int[]{ny, nx, now[2]+1, now[3]+1});
                }
            }
        }
        return res;
    }
}
