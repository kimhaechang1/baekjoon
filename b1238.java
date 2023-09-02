import java.util.*;
import java.io.*;
public class b1238 {
    static ArrayList<Node> [] g;
    static class Node{
        int vertex;
        int w;
        public Node(int v, int w){
            this.vertex =v;
            this.w = w;
        }
    }
    static int N;
    static int M;
    static int X;
    static StringTokenizer stk;
    static final int INF = Integer.MAX_VALUE;
    static boolean [] v;
    static int [] cost1;
    static int [] cost2;
    static int max;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception{
        //  N명의 학생이 있고 어떤 도착점까지의 걸린 비용 중 가장 오래걸린 학생의 소요시간이 필요하다.
        // 각 정점에서부터 X정점까지 최단시간에 오고갔지만 그 시간들중에서 가장 오래걸린 시간을 출력하면된다.
        // 시작점 도착점까지의 최단거리 -> 다익스트라
        // 도착지점에서 모든 출발점까지의 최단거리 시간을 다익스트라로 구하고
        // 각 출발점에서 X까지의 최소비용을 누적하여 그중 가장 큰 값을 출력ㅁ
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());
        g = new ArrayList[N+1];
        v = new boolean[N+1];
        max = Integer.MIN_VALUE;
        for(int i= 1;i<=N;i++){
            g[i] = new ArrayList<>();
        }
        for(int i= 0;i<M;i++){
            stk = new StringTokenizer(bf.readLine());
            int f = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            g[f].add(new Node(t,w));
        }
        cost1 = new int[N+1];
        v = new boolean[N+1];
        Arrays.fill(cost1, INF);
        cost1[X] = 0;
        int cnt = 0;
        pq = new PriorityQueue<>((o1,o2)-> o1.w-o2.w);
        pq.add(new Node(X, cost1[X]));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(v[now.vertex]) continue;
            v[now.vertex] = true;
            if(++cnt == N+1) break;
            for(Node node : g[now.vertex]){
                if(!v[node.vertex] && cost1[node.vertex] > now.w+node.w){
                    cost1[node.vertex] = now.w+node.w;
                    pq.add(new Node(node.vertex, cost1[node.vertex]));
                }
            }
        }
        for(int i= 1;i<=N;i++){
            if(i == X) continue;
            cost2= new int[N+1];
            v = new boolean[N+1];
            Arrays.fill(cost2, INF);
            cost2[i] = 0;
            cnt = 0;
            pq = new PriorityQueue<>((o1,o2)-> o1.w-o2.w);
            pq.add(new Node(i, cost2[i]));
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(v[now.vertex]) continue;
                v[now.vertex] = true;
                if(now.vertex == X) break;
                if(++cnt == N+1) break;
                for(Node node : g[now.vertex]){
                    if(!v[node.vertex] && cost2[node.vertex] > now.w+node.w){
                        cost2[node.vertex] = now.w+node.w;
                        pq.add(new Node(node.vertex, cost2[node.vertex]));
                    }
                }
            }
            cost1[i]+=cost2[X];
        }
//        System.out.println(Arrays.toString(cost1));
        Arrays.sort(cost1);
        System.out.println(cost1[N-1]);
    }
}
