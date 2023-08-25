import java.util.*;
import java.io.*;
public class b10811 {
    static int N;
    static int M;
    static int  [] arr;
    static int [] [] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N+1];
        map = new int[M+1][2];
        for(int i= 1;i<=N;i++){
            arr[i] = i;
        }
        // 1 2 3 4
        // 4 3 2 1
        for(int i= 1;i<=M;i++){
            stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int [] temp = new int[end-start+2];
            for(int j = end;j>=start;j--){
                temp[end-j+1] = arr[j];
            }
            for(int j= start;j<=end;j++){
                arr[j] = temp[j-start+1];
            }
        }
        for(int j= 1;j<=N;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
