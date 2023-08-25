import java.util.*;
import java.io.*;

public class b10810 {
    static int N;
    static int M;
    static int [] map;
    static int [][] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N+1];
        arr = new int[M+1][3];
        for(int i= 1;i<=M;i++){
            stk =new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
            arr[i][2] = Integer.parseInt(stk.nextToken());
        }
        for(int i= 1;i<=M;i++){
            int s = arr[i][0];
            int e = arr[i][1];
            int v = arr[i][2];
            for(int j = s;j<=e;j++){
                map[j] = v;
            }
        }
        for(int i= 1;i<=N;i++){
            System.out.print(map[i]+" ");
        }
    }
}
