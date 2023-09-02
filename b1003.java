import java.util.*;
import java.io.*;

public class b1003 {
    static long [][] dp;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        dp = new long[41][2];
        dp[0][0] = 1; // 0을 만드는데 있어서 0을 호출 한 횟수
        dp[0][1] = 0; // 0을 만드는데 있어서 1을 호출 한 횟수
        dp[1][0] = 0;
        dp[1][1] = 1;
        // fibo(2) = fibo(0) + fibo(1)
        for(int i= 2;i<=40;i++){
            dp[i][0] = dp[i-2][0]+dp[i-1][0];
            dp[i][1] = dp[i-2][1]+dp[i-1][1];
        }

        for(int t= 1;t<=T;t++){
            N = Integer.parseInt(bf.readLine());
            System.out.println(dp[N][0]+" "+dp[N][1]);
        }
    }
}
