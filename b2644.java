import java.util.*;
import java.io.*;
public class b2644 {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int start; // 시작정점
    static int find; // 찾아야할 도착정점
    static ArrayList<Integer> [] g; // 그래프를 인접리스트로 표현하기 위한
    static boolean [] v; // 방문체크
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        // 양방향 그래프이며, 시작정점에서부터 도착정점까지의 길이를 계산해주면 되는 문제
        // 그래프를 표현하고, 주어진 정점에서부터 도착정점까지 count하면 된다.
        // 단, 문제에서 나와있듯 더이상 도착정점까지 나아갈 수 없다면 -1을 리턴한다.
        //
        // 그래프 초기화 진행
        N = Integer.parseInt(bf.readLine());
        g = new ArrayList[N+1];
        for(int i= 1;i<N+1;i++) {
            g[i] = new ArrayList<>();
        }
        v = new boolean[N+1];
        stk = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(stk.nextToken());
        find = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(bf.readLine());
        for(int i = 0;i<M;i++) {
            stk = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            g[v].add(e);
            g[e].add(v);
        }
        // 시작정점부터 너비우선탐색 실행
        System.out.println(bfs(start));
    }
    static int bfs(int node) {
        // 시작정점을 받아서 큐에 넣어주고 시작한다.
        // 이 때 배열로 선언하여서 2번째 인덱스의 원소를 카운팅 용도로 사용한다.
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {node, 0});
        while(!queue.isEmpty()) {
            int [] now = queue.poll();
            if(now[0] == find) return now[1]; // 발견하면 바로 탈출하면 된다.
            v[now[0]] = true;
            for(int nd : g[now[0]]) { // 해당 정점에서의 인접노드를 확인한다.
                if(!v[nd]) { // 이 때 아직 방문한적 없는 노드에대하여 큐에 넣어준다.
                    v[nd] = true;
                    queue.add(new int[] {nd, now[1]+1});
                }
            }
        }
        // 발견하지 못하고 큐의 사이즈가 0이되어 너비우선탐색을 종료했을 경우
        return -1;
    }
}
