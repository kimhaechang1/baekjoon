import java.util.*;
import java.io.*;
public class b1967 {
    static int max;
    static StringTokenizer stk;
    static class Vertex{
        int e;
        int w;
        public Vertex(int e, int w){
            this.e = e;
            this.w = w;
        }

    }
    static ArrayList<Vertex> [] g;
    static int N;
    static int M;
    static boolean []v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = N-1;
        g = new ArrayList[N+1];
        for(int i= 1;i<N+1;i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e= Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            Vertex vtxv = new Vertex(e, w);
            Vertex vtxe = new Vertex(v,w);
            g[v].add(vtxv);
            g[e].add(vtxe);
        }
        max = Integer.MIN_VALUE;
        for(int i= 1;i<N+1;i++){
            v = new boolean[N+1];
            dfs(i, 0);
        }
        System.out.println(max);
    }
    static void dfs(int vtx, int weight){
        v[vtx] = true;
        for(Vertex vt : g[vtx]){
            if(!v[vt.e]){
                v[vt.e] = true;
                dfs(vt.e, weight+vt.w);
                v[vt.e] = false;
            }
        }
        if(weight > max) max = weight;
        v[vtx] = false;
    }
}
