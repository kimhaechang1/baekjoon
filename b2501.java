import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class b2501 {
    static int N;
    static int K;
    static int count;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        int res = -1;
        for(int i=N ;i>0;i--){
            if(N % i == 0){

                count++;
                if(count == K){
                    res = N/i;
                    break;
                }
            }
        }
        System.out.println( (res == -1) ? "0" : res);
    }
}
