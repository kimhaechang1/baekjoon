import java.util.*;
import java.io.*;

public class b9466 {
    static int N;
    static int [] selected;
    static boolean [] v;
    static boolean [] isCycle;

    static StringTokenizer stk;
    static StringBuilder sb;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int t= 1;t<=T;t++){
            N = Integer.parseInt(bf.readLine());
            selected = new int[N+1];
            stk = new StringTokenizer(bf.readLine());
            for(int i= 1;i<N+1;i++){
                selected[i] = Integer.parseInt(stk.nextToken());
            }
            count = 0;
            v = new boolean [N+1];
            isCycle = new boolean [N+1];

            // 어떤 노드를 방문하면 무조건 사이클이 이미 존재하는 곳에 도달하게 된다.
            // 그렇다는 말은 즉, 1 -> 2 -> 3 -> 3 에서도 3->3을 통해 사이클이 발생하는 지점이 있다면
            // 1과 2는 사이클이 발생하는 진입점이지만, 1,2 가 직접적으로 팀을 형성하진 않으며
            // 다음에 다른 노드에서부터 1을 타게 될 일이 생긴다면 이미 결론이 나 있으므로 쓸데없는 탐색을 줄인다.
            // 사이클이 있는 진입점이면 1, 팀이 없는 학생들이면 0,
            for(int i= 1;i<N+1;i++){
                if(!isCycle[i]){
                    dfs(i);
                }

            }

            // 4 6 7
            // 4 6 8
            //System.out.println(Arrays.toString(v));
            sb.append(N-count).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int idx){
        v[idx] = true;
        int next = selected[idx];
        if(!v[next]) dfs(next); // 방문하지 않은 노드들을 타고타고 간다.
        else{
            // 만약 결국 원점으로 돌아왔다면 왔던길이 전부 v[idx] = true가 되어있을 것이다.
            // 해당하는 노드들은 사이클이 존재하는 진입점이 되며, 카운트를 해야 한다.
            if(!isCycle[next]){
                count++;
                isCycle[next] = true;
                while(next !=idx){
                    count++;
                    next = selected[next];
                    isCycle[next] = true;
                }
            }
        }
        // 만약 1 - > 2 -> 3 - > 3의 경우 3번째 3으로 돌아가서 사이클 체크 이후 1,2 는 사이클 진입접으로 표시해야 한다.
        // 따라서 리턴되어 돌아갈 때 사이클 진입점들을 true처리 해준다.
        // 단, 직접적으로 팀을 형성하진 않으므로 count하지 않는다.
        isCycle[idx] = true;
    }
}
