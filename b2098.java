import java.util.*;
import java.io.*;
public class b2098 {
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> g[];
    static int N;
    static StringTokenizer stk;
    static boolean [] v;
    static int []arr;
    static void perm(int depth, int cost, int from){
        if(depth == N){
            cost+=g[arr[depth-1]].get(arr[0]).w;
            if(min > cost){
                min = cost;
            }
            return;
        }
        for(int i= 0;i<N;i++){
            if(!v[i]){
                if(cost+g[from].get(i).w >= min) continue;
                v[i] = true;
                arr[depth] = i;
                perm(depth+1, cost+g[from].get(i).w,i);
                v[i] = false;
            }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        g = new ArrayList[N];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine(), " ");
            g[i] = new ArrayList<>();
            for(int j = 0;j<N;j++){
                int w = Integer.parseInt(stk.nextToken());
                g[i].add(new Node(j, w));
            }
        }
        arr = new int [N];
        v = new boolean[N+1];
        perm(0,0,0);
        System.out.println(min);

    }
    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}

