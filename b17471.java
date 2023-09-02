import java.util.*;
import java.io.*;
public class b17471 {
    static int [][] g;
    static int N;
    static StringTokenizer stk;
    static ArrayList<Integer> g1;
    static ArrayList<Integer> g2;
    static int [] arr;
    static boolean [] selected;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N+1];
        selected = new boolean[N+1];
        g= new int[N+1][N+1];
        stk = new StringTokenizer(bf.readLine());
        for(int i= 1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i= 1;i<=N;i++){
            stk = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(stk.nextToken());
            for(int j= 0;j<num;j++){
                int node = Integer.parseInt(stk.nextToken());
                g[i][node] = 1;
                g[node][i] = 1;
            }
        }
        selected = new boolean[N+1];
        min = Integer.MAX_VALUE;
        dfs(0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
    static void dfs(int depth){
        if(depth == N+1){
            g1 = new ArrayList<>();
            g2 = new ArrayList<>();
            for(int i= 1;i<=N;i++){
                if(selected[i]) g1.add(i);
                else g2.add(i);
            }
            if(g1.size() == 0 || g2.size() == 0) return;
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0;i<g1.size();i++){
                sum1+=arr[g1.get(i)];
            }
            for(int i = 0;i<g2.size();i++){
                sum2+=arr[g2.get(i)];
            }
            if(check()){
                int res = Math.abs(sum2-sum1);
                if(min > res){
                    min= res;
                }
            }

            return;
        }
        selected[depth] = true;
        dfs(depth+1);
        selected[depth] = false;
        dfs(depth+1);
    }
    static boolean check(){
        boolean [] v = new boolean[N+1];
        go(v,g1.get(0),g1);
        go(v,g2.get(0),g2);
        for(int i= 1;i<=N;i++){
            if(!v[i]) return false;
        }
        return true;
    }
    static void go(boolean [] visited, int startNode, ArrayList<Integer> group){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;
            for(int i= 1;i<=N;i++){
                if(!visited[i] && g[now][i] == 1 && group.contains(i)){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }



}
