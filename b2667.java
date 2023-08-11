import java.io.*;
import java.util.*;
public class b2667 {
    static int N;
    static int count;
    static int[][]map;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int [] dy= {0,1,0,-1};
    static int [] dx ={-1,0,1,0};
    static void bfs(int i, int j){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        map[i][j] = count;
        int cnt = 1;
        while(!q.isEmpty()){
            int [] now = q.poll();
            for(int k= 0;k<4;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny >=N || ny<0 || nx>=N || nx<0) continue;
                if(map[ny][nx] == 1){
                    map[ny][nx] = count;
                    cnt++;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        queue.add(cnt);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i= 0;i<N;i++){
            String t = bf.readLine();
            for(int j = 0;j<N;j++){
                map[i][j] = t.charAt(j)-'0';
            }
        }
        count = 2;
        for(int i= 0;i<N;i++){
            for(int j= 0;j<N;j++){
                if(map[i][j] == 1){
                    bfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count-2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
