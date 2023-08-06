import java.util.*;
import java.io.*;
public class b15665 {
    static int N;
    static int M;
    static int []res;
    static int [] arr;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static void permWithRep(int depth){
        if(depth == M){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i= 0;i<N;i++){
            if(prev == arr[i]) continue;
            res[depth] = arr[i];
            prev = res[depth];
            permWithRep(depth+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        res = new int[M];
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        permWithRep(0);
        System.out.print(sb);
    }
}
