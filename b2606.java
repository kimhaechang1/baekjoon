import java.util.*;
import java.io.*;
public class b2606 {
    static ArrayList<Integer> [] g;
    static int N;
    static int M;
    static int count;
    static StringTokenizer stk;
    static boolean [] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        count = 0;
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        g = new ArrayList[N+1];
        for(int i= 1;i<=N;i++){
            g[i] = new ArrayList<>();
        }
        for(int i= 0;i<M;i+=1){
            stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            g[v].add(e);
            g[e].add(v);
        }
        v = new boolean[N+1];
        dfs(1);
        System.out.println(count);

    }
    static void dfs(int node){
        v[node] = true;
        for(int a : g[node]){
            if(!v[a]){
                count++;
                dfs(a);
            }
        }
    }
}
