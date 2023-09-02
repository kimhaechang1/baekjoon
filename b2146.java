import java.util.*;
import java.io.*;
public class b2146 {
    static int [][] map;
    static boolean [][] v;
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};
    static int N;
    static StringTokenizer stk;
    static int min;
    static Queue<int []> queue;
    static boolean [][][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // 우선 섬들이 현재 모두 1로 되어있는 부분에 대하여
        // 다른섬들은 다른 숫자로 표기하게 만든다.
        queue = new LinkedList<>();
        v = new boolean[N][N];
        int cnt = 0;
        for(int i = 0;i<N;i++){
            for(int j= 0;j<N;j++){
                if(map[i][j] == 1 && !v[i][j]){
                    cnt++;
                    queue.add(new int[]{i,j});
                    make(cnt);
                }
            }
        }


        queue.clear();
        visited = new boolean[N][N][cnt+1];
        min = Integer.MAX_VALUE;
        // 0과 인접해있는 좌표들에 대하여 cnt 와 함께 int[]배열로 저장하고
        // 다른 숫자가 있는 섬까지 4방향 탐색을 하며 찾아간다.
        // 그 때 다른섬에 도달했을때 마다 min값을 갱신한다.
        // -> int형 visited로 탐색하려 했더니 이전에 다른섬에서 출발했던 부분을 지워버리는 현상 발생
        // -> 결국 무한루프가 돌 수 있게 되어서 1번섬 2번섬 3번섬... N번섬에서 출발하는 visited를 저장하는 3차원 visited로 교체
        for(int i = 0;i<N;i++){
            for(int j= 0;j<N;j++){
                if(map[i][j] >= 1 && v[i][j]){
                    visited[i][j][map[i][j]] = true;
                    for(int k = 0;k<4;k++){
                        int ny = i+dy[k];
                        int nx = j+dx[k];
                        if(ny >= N || ny< 0 || nx >=N || nx<0 || visited[ny][nx][map[i][j]] || map[ny][nx] != 0) continue;
                        visited[ny][nx][map[i][j]] = true;
                        queue.add(new int[]{ny,nx, map[i][j], 1});
                    }
                }
            }
        }
        go();
        System.out.println(min);
    }
    static void make(int marker){
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            v[now[0]][now[1]] = true;
            map[now[0]][now[1]] = marker;
            for(int k= 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if(ny >= N || ny< 0 || nx >=N || nx<0 || v[ny][nx] || map[ny][nx] == 0) continue;
                if(map[ny][nx] == 1){
                    v[ny][nx] = true;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }
    static void go(){
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(min <= now[3]) continue;
            for(int k= 0;k<4;k++){
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];

                if(ny >= N || ny< 0 || nx >=N || nx<0 || visited[ny][nx][now[2]]) continue;
                if(map[ny][nx] > 0) {
                    if (map[ny][nx] != now[2]) {
                        if (min > now[3]){
                            min = now[3];
                        }
                        continue;
                    }
                }
                if(map[ny][nx] != now[2]){
                    visited[ny][nx][now[2]] = true;
                    queue.add(new int[]{ny,nx, now[2], now[3]+1});
                }
            }
        }
    }
}
