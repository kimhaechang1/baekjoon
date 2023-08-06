import java.util.*;
import java.io.*;
public class b15655 {
    static int N;
    static int M;
    static int [] arr;
    static int [] res;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static void comb(int depth, int start) {
        if(depth == M){
            for(int a  : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = start;i<N;i++){
            res[depth] = arr[i];
            comb(depth+1, i+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        res = new int[M];
        arr = new int[N];
        stk = new StringTokenizer(bf.readLine(), " ");
        for(int i= 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        comb(0,0);
        System.out.print(sb);
    }
}
