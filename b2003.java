import java.util.*;
import java.io.*;
public class b2003 {
    static int []arr;
    static int find;
    static int N;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        find = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for(int i= 0;i<N;i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        // 연속된 수열의 합이 특정 숫자가 되는경우 이므로
        // 누적합을 구하여 구간합이 5가 되는 경우를 찾으면 된다.

        int [] S = new int[N+1];
        for(int i= 0;i<N;i++){
            S[i+1] = S[i]+arr[i];
        }
        int start = 0;
        int end = 1;
        int count = 0;
        while(end !=S.length){
            int val = S[end] - S[start];
            if(val == find){
                count++;
                start++;
            }else if(val > find){
                start++;
            }else {
                end++;
            }

        }
        System.out.println(count);
    }
}
