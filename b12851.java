import java.util.*;
import java.io.*;
public class b12851 {
    static int N;
    static int K;
    static int cnt;
    static int time;
    static StringTokenizer stk;
    static Queue<Integer> queue;
    static int [] v;
    public static void main(String[] args) throws Exception{
        // 내가 해당 지점까지 도달할 수 있는 모든 경우의수를 구해야 한다.
        // 여기서 핵심은 일반적인 true false 방문체커가 아닌
        // 해당 지점까지 걸린 시간을 기록하는 int형 방문체커가 필요하다.
        // 단 한번도 방문한 적이 없다면 0 값을 기록하고 있으므로 그대로 방문하면서 시간을 체크하고
        // 방문한 흔적이 있다면 정답 후보가 될 가능성이 존재하는지 체크하고 큐에 다시 보낸다.(원래 기록된 해당 지점까지의 걸린 시간과 같거나 더 작을때)
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        if(N>= K){
            System.out.println(N-K);
            System.out.println(1);
        }else{
            v = new int[100001];
            time = Integer.MAX_VALUE;
            cnt = 0;
            queue = new LinkedList<>();
            queue.add(N);
            bfs();
            System.out.println(time);
            System.out.println(cnt);
        }
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int now= queue.poll();
            //System.out.println(now);
            if(now == K){
                if(v[now] < time ){
                    time = v[now];
                    cnt = 1;
                }else if(v[now]== time){
                    cnt++;
                }
                continue;
            }
            if(time < v[now]) return;
            for(int i= 0;i<3;i++){
                int num;
                if(i == 0) num = now+1;
                else if(i == 1) num = now-1;
                else num = now*2;

                if(num > 100000 || num < 0) continue;

                if(v[num] == 0){
                    v[num] = v[now]+1;
                    queue.add(num);
                    continue;
                }
                if(v[num] == v[now]+1 || v[num]> v[now]+1){
                    v[num] = v[now]+1;
                    queue.add(num);
                }
            }
        }
    }
}
