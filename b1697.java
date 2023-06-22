import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697 {
    static int min = Integer.MAX_VALUE;
    static int k;
    static StringTokenizer stk;
    static int [] d = {-1,1,2};
    static boolean [] v = new boolean[100001];
    static void bfs(int present){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{present, 0});
        v[present] = true;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(now[0] == k){
                if(now[1] < min){
                    min = now[1];
                }
                continue;
            }
            int [] newNow;
            for(int i = 0;i<3;i++){
               if(i ==2) newNow = new int[]{now[0]*d[i],now[1]+1};
               else newNow = new int[]{now[0]+d[i],now[1]+1};
               if(newNow[0] >=0 && newNow[0]<100000 && !v[newNow[0]]){
                   v[newNow[0]] = true;
                   queue.add(newNow);
               }
            }

        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        bfs(n);
        System.out.println(min);
    }
}
/*
* BFS로 모든 방향성에대한 접근이 필요한 문제
* 방향성 문제이지만 영역에 대한 방향성이 아닌문제라서 헷갈린듯함
* 중요한점은 어떤 방향성 체크든 out of boundary 체크는 해줘야하고
* 만약에 메모리 초과가 날 시 방문체커를 사용한다!*/
