import java.util.*;
import java.io.*;
public class b9663_2 {
    static int N;
    static int [] arr;
    static boolean[] v; // 가로줄
    static boolean [] v1; // 오른쪽 아래 대각선
    static boolean [] v2; // 왼쪽 아래 대각선
    static int count;
    static void dfs(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i= 0;i<N;i++){
            arr[depth] = i;
            int idx1 = 0;
            int idx2 = i+depth;
            if(i-depth < 0) idx1 = i-depth+(2*N-1);
            else idx1 = i-depth;
            if(!v[i] && !v1[idx1] && !v2[idx2]){
                v[i] = true;
                v1[idx1] = true;
                v2[idx2] = true;
                dfs(depth+1);
                v[i] = false;
                v1[idx1] = false;
                v2[idx2] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        v = new boolean[N];
        v1 = new boolean[N-1+N];
        v2 = new boolean[N-1+N];
        arr = new int[N];
        count = 0;
        dfs(0);
        System.out.println(count);
    }

}
