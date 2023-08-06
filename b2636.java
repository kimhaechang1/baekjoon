import java.util.*;
import java.io.*;
public class b2636 {
    // 이 문제에 특징은 일단 한 순간에 범위영역을 탐색해야한다 --> BFS를 의미한다.
    // 또한 공기 칸이 치즈에게 둘러쌓여있다면 해당 공기영역에 접촉 해 있는 치즈칸은 무시한다.
    // 따라서 외부 공기에서 방향벡터를 이용한 탐색을 한 후 치즈중에서 외부공기와 접해있다면 방문을 한다.
    static int count = 0;
    static int time = 0;
    static int [][] map;
    static int N;
    static int M;
    static StringTokenizer stk;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static boolean [][] v;
    static void bfs(int y, int x){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        v[y][x] = true;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k= 0;k<4;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny < 0 || ny>=N || nx < 0 || nx >=M || v[ny][nx]) continue;
                if(map[ny][nx] == 1){
                    map[ny][nx] = 2;
                }
                else if(map[ny][nx] == 0){
                    v[ny][nx] = true;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine()," ");
        N  = Integer.parseInt(stk.nextToken());
        M  = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i = 0;i<N;i++){
            String [] temp = bf.readLine().split(" ");
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(temp[j]);
                if(map[i][j] == 1) count++;

            }
        }
        v = new boolean[N+1][M+1];
        bfs(0,0);
        time++;


        while(true){
            int cc = 0;
            for(int i= 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    if(map[i][j] == 2){
                        map[i][j] = 0;
                    }
                    else if(map[i][j] == 1){
                        cc++;
                    }
                }
            }
            if(cc == 0){
                break;
            }
            v = new boolean[N+1][M+1];
            count = cc;
            time++;
            bfs(0,0);

        }
        System.out.println(time);
        System.out.println(count);
    }
}
