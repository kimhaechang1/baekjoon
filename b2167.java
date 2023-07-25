import java.io.*;
import java.util.*;
public class b2167 {
    static int N;
    static int M;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String [] t = bf.readLine().split(" ");
        N = Integer.parseInt(t[0]);
        M = Integer.parseInt(t[1]);
        int [][] map = new int[N][M];
        int [][] tmap = new int[N+1][M+1];
        for(int i = 0;i<N;i++){
            stk= new StringTokenizer(bf.readLine()," ");
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i = 1;i<=N;i++){
            for(int j= 1;j<=M;j++){
                tmap[i][j] = tmap[i-1][j]+tmap[i][j-1] + map[i-1][j-1]-tmap[i-1][j-1];
            }
        }
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++){
            stk = new StringTokenizer(bf.readLine()," ");
            int y1 = Integer.parseInt(stk.nextToken());
            int x1 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int result = tmap[y2][x2] - tmap[y2][x1-1]-tmap[y1-1][x2]+tmap[y1-1][x1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
