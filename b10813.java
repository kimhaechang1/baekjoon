import java.util.*;
import java.io.*;
public class b10813 {
    static int [] arr;
    static int N;
    static int M;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N+1];
        for(int i= 1;i<=N;i++){
            arr[i] = i;
        }
        for(int i = 0;i<M;i++){
            stk = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e]  =temp;
        }
        for(int i= 1;i<=N;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
