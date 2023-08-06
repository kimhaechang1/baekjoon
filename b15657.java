import java.io.*;
import java.util.*;
public class b15657{
    static int N;
    static int M;
    static int [] res;
    static int [] arr;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static void combWithRep(int depth, int start){
        if(depth == M){
            for(int a : res ) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i= start;i<N;i++){
            res[depth] = arr[i];
            combWithRep(depth+1, i);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine(), " ");
        res = new int[M];
        arr = new int[N];
        for(int i= 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        combWithRep(0,0);
        System.out.print(sb);
    }
}
