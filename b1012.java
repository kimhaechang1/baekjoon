import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1012 {
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static int [][] map;
    static int cols;
    static int rows;
    static int count = 2;
    static StringTokenizer stk;
    static void bfs(int y, int x){
        Queue<int []> queue= new LinkedList<>();
        queue.add(new int[]{y,x});
        map[y][x] = count;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
//            System.out.println(now[0]+" "+now[1]);
            for(int i= 0;i<=3;i++){
                int ny = now[0]+dy[i];
                int nx = now[1]+dx[i];
                if(ny > -1 && ny<cols && nx > -1 &&nx < rows && map[ny][nx] == 1){
                    map[ny][nx] = count;
                    queue.add(new int[]{ny,nx});
                }
            }
//            for(int j = 0;j<cols;j++){
//                for(int p = 0;p<rows;p++){
//                    System.out.print(map[j][p]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("------------------");
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0;i<T;i++){
            count = 2;
            stk = new StringTokenizer(bf.readLine());
            rows = Integer.parseInt(stk.nextToken());
            cols = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            map = new int[cols][rows];
            for(int j=0;j<k;j++){
                stk = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                map[y][x] = 1;
            }

            for(int j = 0;j<cols;j++){
                for(int p = 0;p<rows;p++){
                    if(map[j][p] == 1){
                        bfs(j,p);
                        count++;
                    }
                }
            }

            System.out.println(count-2);
        }
    }
}
