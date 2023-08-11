import java.util.*;
import java.io.*;
public class b2583 {
    static int N;
    static int M;
    static int K;
    static int [][] map;
    static int count; // 사각형 개수
    static PriorityQueue<Integer> width = new PriorityQueue<>();
    static int [] dy = {0,-1,0,1};
    static int [] dx = {1,0,-1,0};
    static StringTokenizer stk;
    static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        map[i][j] = count;
        int cnt = 1;
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k= 0;k<4;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny >=M || ny<0 || nx>=N || nx<0) continue;
                if(map[ny][nx] == 0){
                    map[ny][nx] = count;
                    cnt++;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        width.add(cnt);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        map = new int[M][N];
        for(int i= 0;i<K;i++){
            stk = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(stk.nextToken());
            int x1 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());

            for(int y = y1;y<y2;y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        count = 2;
        for(int i= 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(map[i][j] == 0){

                    bfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count-2);
        while(!width.isEmpty()){
            System.out.print(width.poll()+" ");
        }

    }
}
