import java.util.*;
import java.io.*;

public class b2468 {
    static int [][] temp;
    static int [][] map;
    static int count;
    static int N;
    static int max = 0;
    static StringTokenizer stk;
    static int [] dy = {0,1,0,-1};
    static int [] dx = {1,0,-1,0};
    static void bfs(int i, int j){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        temp[i][j] = count;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k= 0;k<4;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny >=N || ny<0 || nx>=N || nx<0) continue;
                if(temp[ny][nx] == 0){
                    temp[ny][nx] = count;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        max = 1; // 아무런 건물도 잠기지 않은 경우
        int maxh = -1;
        int minh = 101;
        map= new int[N][N];
        for(int i= 0;i<N;i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (maxh < map[i][j]) {
                    maxh = map[i][j];
                }
                if (minh > map[i][j]) {
                    minh = map[i][j];
                }
            }
        }
        for(int i = minh ;i<= maxh;i++){
            temp = new int[N][N];
            count = 2;
            for(int j = 0;j<N;j++){
                for(int k= 0;k<N;k++){
                    if(map[j][k] <= i){
                        temp[j][k]= 1;
                    }
                }
            }
            for(int j= 0;j<N;j++){
                for(int k= 0;k<N;k++){
                    if(temp[j][k] == 0){
                        bfs(j,k);
                        count++;
                    }
                }
            }
            /*for(int m= 0;m<N;m++){
                for(int n = 0;n<N;n++){
                    System.out.print(temp[m][n]);
                }
                System.out.println();
            }*/
            if(max < (count-2)){
                max = (count-2);
            }

        }
        System.out.println(max);
    }
}
