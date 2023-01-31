import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11660 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int qnum = Integer.parseInt(stk.nextToken());
        int [][] a = new int[n+1][n+1];
        int [][] r = new int[n+1][n+1];
        int []t = new int[qnum];
        for(int i = 1;i<n+1;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 1;j<n+1;j++){
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i = 1;i<n+1;i++){
            for(int j =1;j<n+1;j++){
                r[i][j] = r[i-1][j] + r[i][j-1] - r[i-1][j-1]+a[i][j];
            }
        }
        for(int i = 0;i<qnum;i++){
            stk = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            t[i] = r[x2][y2] - r[x1-1][y2] - r[x2][y1-1]+r[x1-1][y1-1];
        }
        for(int k : t) System.out.println(k);
    }
}
