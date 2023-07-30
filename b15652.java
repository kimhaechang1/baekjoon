import java.util.*;
import java.io.*;
public class b15652 {
    static int N;
    static int M;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth, int start){
        if(depth == M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start;i<=N;i++){
            arr[depth] = i;
            dfs(depth+1,i);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] buffer = bf.readLine().split(" ");
        N = Integer.parseInt(buffer[0]);
        M = Integer.parseInt(buffer[1]);
        arr =new int[M];
        dfs(0,1);
        System.out.println(sb);
    }
}
