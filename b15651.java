import java.util.*;
import java.io.*;
public class b15651 {
    static int N;
    static int M;
    static StringBuilder sb;
    static int [] arr;

    static void dfs(int depth){
        if(depth == M){
            for(int i = 0;i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1;i<=N;i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] NM = bf.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new int[M];
        sb = new StringBuilder();
        dfs(0);
        System.out.println(sb);
    }
}
