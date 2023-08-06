import java.util.*;
import java.io.*;
public class b18809 {
    static int N;
    static int M;
    static int G;
    static int R;
    static int [][] map;
    static ArrayList<Pos> list;
    static boolean [] v;
    static int [] gres;
    static int [] rres;
    static int max;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static StringTokenizer stk;
    static class Pos{
        // 좌표 클래스
        int x;
        int y;
        public Pos(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    static class Map{
        // 임시 지도 클래스
        int time; // 배양액이 퍼진 시간
        int type; // 배양액 타입
        public Map(){}

        public Map(int time, int type){
            this.time = time;
            this.type = type;
        }
    }
    static void permG(int depth, int start){
        // 조합은 조합이지만, G에서 선택한 부분을 R에서 선택하면 안되기 때문에 방문체크가 필요하다.
        if(depth == G){
            permR(0,0);
            return;
        }
        for(int i = start;i<list.size();i++){
            if(!v[i]){
                v[i] = true;
                gres[depth] = i;
                permG(depth+1,i+1);
                v[i] = false;
            }

        }
    }

    static void permR(int depth, int start){
        if(depth == R){
            bfs();
            return;
        }
        for(int i = start;i<list.size();i++){
            if(!v[i]){
                v[i] = true;
                rres[depth] = i;
                permR(depth+1, i+1);
                v[i] = false;
            }
        }
    }
    static void bfs(){
        Queue<Pos> queue =new LinkedList<>();
        // 새로운 맵을 저장 할 배열 ->
        // 새로운 맵이 필요한 이유 : 지도에 현재 타입도 적어야하지만 그 배양액이 퍼진 시간도 기록해야 하므로
        Map[][] temp = new Map[N][M];

        for(int i= 0;i<N;i++){
            for(int j= 0;j<M;j++){
                temp[i][j] = new Map();
            }
        }
        for(int i= 0;i<R;i++){
            // rres에는 배양액을 놓을 수 있는 좌표들 중 어떤 인덱스 번호를 선택했는지 담겨있다.
            Pos p = list.get(rres[i]);
            temp[p.y][p.x] = new Map(0,4);
            queue.add(new Pos(p.y,p.x));
        }
        for(int i= 0;i<G;i++){
            // gres는 마찬가지이다.
            Pos p = list.get(gres[i]);
            temp[p.y][p.x] = new Map(0,3);
            queue.add(new Pos(p.y,p.x));
        }
        // 어짜피 1이나 0이나 배양액이 흐를 수 있으므로 다 0으로 친다.
        int count = 0;
        while(!queue.isEmpty()){
            /*for(int i= 0;i<N;i++){
                for(int j = 0;j<M;j++){
                    System.out.print(temp[i][j].type+" ");
                }
                System.out.println();
            }
            System.out.println("-----");*/
            Pos now = queue.poll();
            // 큐에서 하나를 꺼내고 현재 퍼뜨릴 녀석이 누구인지 파악한다.
            int cTime = temp[now.y][now.x].time;
            int cType = temp[now.y][now.x].type;
            // 그 좌표가 꽃이 폈다면? 퍼뜨릴 수가 없는 상황이 된다.
            if(temp[now.y][now.x].type == 5){
                continue;
            }
            // 4방향 탐색
            for(int k =0;k<4;k++){
                int ny = now.y+dy[k];
                int nx = now.x+dx[k];
                // 호숫가에도 배양액이 흐르면 안된다.
                if(ny < 0 || ny>=N || nx<0||nx>=M || map[ny][nx] ==0) continue;

                if(temp[ny][nx].type == 0){
                    temp[ny][nx] = new Map(cTime+1, cType);
                    queue.add(new Pos(ny,nx));
                }else if(temp[ny][nx].type == 3){
                    // 현재 배양액이 R고 흘려보낼 칸에 배양액이 G이 채워져 있다면
                    // 꽃이 필 조건이 되고, 둘의 동시성을 생각한다면 이전에 찍어놓은 시간과 동일한지는 1 차이로 볼 수 있다.
                    if(cType == 4 && temp[ny][nx].time == cTime+1){
                        count++;
                        temp[ny][nx].type = 5;
                    }
                }else if(temp[ny][nx].type == 4){
                    if(cType == 3 && temp[ny][nx].time == cTime+1){
                        count++;
                        temp[ny][nx].type = 5;
                    }
                }

            }
        }
        if(max < count){
            max = count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        G = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        list =new ArrayList<>();
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());

                if(map[i][j] == 2){
                    list.add(new Pos(i,j));
                }
            }
        }
        // G와 R이 선택할 수 있는 각각의 최대 인덱스 개수
        v = new boolean[10];
        gres = new int[G];
        rres = new int[R];
        permG(0,0);
        System.out.println(max);

    }
}
