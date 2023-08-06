import java.util.*;
import java.io.*;
public class b15664 {
    static int N;
    static int M;
    static int [] res;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;
    static void comb(int depth, int start){
        if(depth == M){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i= start;i<N;i++){
            int temp = res[depth];
            if(prev == arr[i]){
                continue;
            }

            res[depth] = arr[i];
            prev = res[depth];
            comb(depth+1, i+1);
            res[depth] = temp;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        arr = new int[N];
        res = new int[M];
        for(int i= 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        comb(0,0);
        System.out.print(sb);
    }
}
