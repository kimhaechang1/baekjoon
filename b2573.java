import java.util.*;
import java.io.*;
public class b2573 {
    static int[][] map;
    static int N;
    static int M;
    static StringTokenizer stk;
    static int time;
    static int [] dy = {-1,1,0,0};
    static int [] dx=  {0,0,-1,1};
    static Queue<int []> queue;
    static boolean [][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        time = 0;

        while(true){
            int cnt = 0;
            // 빙산들이 이어져 있는지 검사
            queue = new LinkedList<>();
            ArrayList<int []> list = new ArrayList<>();
            v = new boolean[N][M];
            for(int i = 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    if(map[i][j] > 0){
                        if(cnt==0)queue.add(new int[]{i,j});
                        list.add(new int[]{i, j, map[i][j]});
                        cnt++;
                    }
                }
            }

            if(cnt == 0){
                // 빙산들이 모조리 녹을 때 까지 기다려야 했다면 0을 출력한다.
                time = 0;
                break;
            }else if(cnt > bfs()){
                break;
            }
            time++;
            // 빙산들이 이어져 있다면 시간을 늘려서 4방향검사에 0의 개수에 따라 discount
            for(int [] now : list){
                int zeroc = 0;
                for(int k= 0;k<4;k++){
                    int ny = now[0]+dy[k];
                    int nx = now[1]+dx[k];
                    if(ny >=N || ny<0 || nx>=M || nx<0) continue;
                    if(map[ny][nx] == 0) zeroc++;
                }
                now[2] = now[2]-zeroc;
            }

            for(int [] now : list){
                if(now[2] > 0){
                    map[now[0]][now[1]] = now[2];
                }else{
                    // 0보다 작은값을 넣을 순 없다.
                    map[now[0]][now[1]] = 0;
                }
            }
        }
        System.out.println(time);

    }
    static int bfs(){
        int cnt = 1;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            v[now[0]][now[1]] = true;
            for(int k= 0;k<4;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny >=N || ny<0 || nx>=M || nx<0 || v[ny][nx] ||map[ny][nx] == 0) continue;
                if(map[ny][nx] > 0){
                    cnt++;
                    v[ny][nx] = true;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        return cnt;
    }
}
