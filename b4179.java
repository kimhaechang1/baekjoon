import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4179 {
    static char [][] map;
    static boolean [][] visited;
    static int []dy = {-1,0,1,0};
    static int []dx = {0,-1,0,1};
    static int cols;
    static int rows;
    static int answer = 0;
    static StringTokenizer stk;

    static Queue<int []> jihun = new LinkedList<>();
    static Queue<int []> fire = new LinkedList<>();
    static boolean bfs(){
        while(!jihun.isEmpty()){
            int fireSize = fire.size();

            while(fireSize-- > 0){
                int [] fireCoord = fire.poll();
                for(int i = 0;i<4;i++){
                    int ny = fireCoord[0] + dy[i];
                    int nx = fireCoord[1] + dx[i];
                    if(ny> -1 && ny<cols &&nx > -1 && nx<rows && map[ny][nx] =='.'){
                        map[ny][nx] = 'F';
                        fire.add(new int[]{ny,nx});
                    }
                }
            }
            int jihunSize = jihun.size();
            while(jihunSize-->0){
                int [] jihunState = jihun.poll();
                for(int i =0;i<4;i++){
                    int ny = jihunState[0] + dy[i];
                    int nx = jihunState[1] + dx[i];
                    if(ny<0 || nx < 0 || nx>=rows || ny>=cols){
                        answer = jihunState[2]+1;
                        return true;
                    }
                    if(map[ny][nx] =='.'){
                        map[ny][nx] = 'J';
                        jihun.add(new int[]{ny,nx,jihunState[2]+1});
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        // 불, 지훈 순서대로 좌표를 넣어줘야 불먼저 확산시키고 지훈이가 이동한다.
        // 현재 지훈의 위치가 가장자리인지 검사해야하고, 가장자리라면 더이상 불도 지훈도 이동할 필요가 없다.
        // 가장자리가 아닐시에는 분을 하나씩 카운트 하여야 한다. 단, BFS이기 때문에 같은 시간에 이동할 방향이 여러방면이다.
        // 지훈의 시작점 좌표를 구해야하고, 불의 시작점 좌표를 구해서, 불 먼저 들어가도록 정의
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        cols = Integer.parseInt(stk.nextToken());
        rows = Integer.parseInt(stk.nextToken());
        map = new char[cols][rows];
        for(int i = 0;i<cols;i++){
            String temp= bf.readLine();
            for(int j = 0;j<rows;j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j]=='J'){
                    jihun.add(new int[]{i,j,0});
                }else if(map[i][j] =='F'){
                    fire.add(new int[]{i,j});
                }
            }
        }
        // 문제의 핵심은 불 확산에 있는데, 1분당의 불만큼을 확산시켜야 한다.
        // 이를 위해서 사전에 측정된 불 큐의 크기만큼만 불을 확신시켜야 한다.
        // 사람도 그렇게 이동시켜야 한다. 결국 이렇게하면 1분당 불먼저 후 사람 확산이 이뤄진다.
        if(bfs()){
            System.out.println(answer);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
