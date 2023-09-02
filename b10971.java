import java.util.*;
import java.io.*;

public class b10971 {
    static int N;
    static int [][]g;
    static StringTokenizer stk;
    static StringBuilder sb;
    static int [][] dp;
    static int min;
    static boolean [] v;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        g = new int[N][N];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<N;j++){
                g[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 간선 4개를 선택해야 한다.
        // 다른 순회에서도 반복되는 순회 방법연산이 겹칠 것이다.
        // 예를들어 1 -> 2 같은 경우
        // 0 -> 1 -> 2 -> 3 -> 0 에서 쓰일수도 있고
        // 1 -> 2 -> 0 -> 3 -> 1 에서 쓰일수도 있다.

        // 중첩이 되는 부분은 있는것 같은데 메모를 어떻게 해야할지 잘 모르겠음
        // 일단 어떤 임의 정점에서부터 한바퀴 돌아야 한다. -> dfs로 구현해본다.
        // 4개의 정점을 고르는것이 우선이고
        // 첫번째 정점을 제외한 나머지 3개를 골랐을 때 마지막 선택한 정점번호에서
        // 처음 시작한 정점번호로 가는 간선이 존재 할 경우 더하여 min값 갱신
        // 방문했던 노드는 다른 경우에서 또 방문할 수 있기 때문에 방문해제 꼭 해줘야한다.
        min = Integer.MAX_VALUE;

        for(int i= 0;i<N;i++){
            v = new boolean[N];
            v[i] = true;
            dfs(0,i, i, 0);
        }
        System.out.println(min);

    }
    static void dfs(int depth, int start, int from, int val){
        if(depth == N-1){ // 이미 하나를 선택한채로 시작하므로
            if(g[from][start]!=0){
                min = Math.min(min, val+g[from][start]);
            }
            return;
        }
            for(int i = 0;i<N;i++){
               if(!v[i] && g[from][i]!=0) { // 방문한적이 없는 노드면서 간선이 있다면
                   v[i] = true; // 방문체크해주고
                   dfs(depth + 1, start, i, val + g[from][i]); // 다음 노드를 선택하러 간다.
                   v[i] = false; // 끝까지 선택하고 돌아왔다면 다른 선택지에서 사용할 수 있게 다시 방문 해제 해 준다.
               }
            }
        }
}
