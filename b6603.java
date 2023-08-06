import java.util.*;
import java.io.*;
public class b6603 {
    static int N;
    static int M = 6;
    static int [] res;
    static int [] arr;
    static StringBuilder sb;
    static StringTokenizer stk;
    static void comb(int depth, int start){
        if(depth == M){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i= start;i<N;i++){
            res[depth] = arr[i];
            comb(depth+1, i+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            stk =new StringTokenizer(bf.readLine());
            N = Integer.parseInt(stk.nextToken());
            if(N == 0){
                break;
            }
            sb = new StringBuilder();
            res = new int[M];
            arr = new int[N];
            for(int i= 0;i<N;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            comb(0,0);
            System.out.println(sb);
        }
    }
}
