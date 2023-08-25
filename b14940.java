import java.util.*;
import java.io.*;
public class b14940 {
    static int N;
    static int M;
    static StringTokenizer stk;
    static int [][] map;
    static boolean [][]v;
    static int [] dy={1,0,-1,0};
    static int [] dx={0,1,0,-1};
    static int ty;
    static int tx;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2){
                    ty = i;
                    tx = j;
                    map[i][j] = 0;
                }
            }
        }
        v = new boolean[N][M];
        bfs(ty,tx);

        for(int i= 0;i<N;i++){
            for(int j= 0;j<M;j++){
                if(!v[i][j] && map[i][j] == 1){
                    System.out.print("-1" +" ");
                }
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(int sy, int sx){
        Queue<int []> queue =  new LinkedList<>();
        v[sy][sx] = true;
        queue.add(new int[]{sy,sx,0});
        while(!queue.isEmpty()){
            int []now = queue.poll();
            for(int k= 0;k<4;k++){
                int ny= now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny >=N || ny < 0 || nx>=M ||nx<0 || map[ny][nx] == 0 ||v[ny][nx]) continue;
                v[ny][nx] = true;
                map[ny][nx] = map[now[0]][now[1]]+1;
                queue.add(new int[] {ny, nx, now[2]+1});
            }
        }
    }
}
