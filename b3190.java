import java.util.*;
import java.io.*;
public class b3190 {
    static int [][] map;
    static int N;
    static int K;
    static int L;
    static String [] turn;
    static StringTokenizer stk;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,1,0,-1};
    static int d;
    static int time;
    static ArrayDeque<int []> deque;
    // 시뮬레이션 문제면 우선 BFS, DFS를 생각하기 앞서 어떻게 시뮬레이션을 돌릴까를 생각하기
    // 이번문제는 중점적으로 봐야할것이 뱀의 꼬리와 머리의 상태 즉, 뱀의 상태를 중점적으로 생각해야 한다.
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        map = new int[N+1][N+1];
        for(int i = 0;i<K;i++){
            stk = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = 2;
        }
        turn = new String[10001];
        L = Integer.parseInt(bf.readLine());
        for(int i = 0;i<L;i++){
            stk = new StringTokenizer(bf.readLine());
            turn[Integer.parseInt(stk.nextToken())] = stk.nextToken();
        }
        d = 1;
        deque = new ArrayDeque<>();
        deque.addFirst(new int[]{1,1});
        time = 0;
        while(true){
            time++;
            int [] head = deque.peekFirst();
            int ny = head[0]+dy[d];
            int nx = head[1]+dx[d];

            if(ny <1 || ny> N || nx<1 || nx>N || map[ny][nx] == 1) break;

            if(map[ny][nx] == 2){
                map[ny][nx] = 1;
                deque.addFirst(new int[]{ny, nx});
            }else if(map[ny][nx] == 0){
                map[ny][nx] = 1;
                deque.addFirst(new int[]{ny,nx});
                int [] tail = deque.pollLast();
                map[tail[0]][tail[1]] = 0;
            }
            if(turn[time] !=null){
                if(turn[time].equals("D")){
                    d+=1;
                    if(d == 4) d=0;
                }else if(turn[time].equals("L")){
                    d-=1;
                    if(d<0) d=3;
                }
            }
        }
        System.out.println(time);

    }
}
