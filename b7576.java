import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {
    static int rows;
    static int cols;
    static int [][] map;
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static Queue<int []> queue;
    static void bfs(){
        while(!queue.isEmpty()){
            int [] coord = queue.poll();
            for(int i= 0;i<4;i++){
                int ny = coord[0]+dy[i];
                int nx = coord[1]+dx[i];
                if(ny > -1 && ny<cols && nx>-1 && nx<rows && map[ny][nx] == 0){

                    queue.add(new int[]{ny, nx});
                    map[ny][nx] = map[coord[0]][coord[1]]+1;
                }
            }
        }

    }
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        rows = Integer.parseInt(stk.nextToken());
        cols = Integer.parseInt(stk.nextToken());
        map = new int[cols][rows];
        queue =new LinkedList<>();
        for(int i = 0;i<cols;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<rows;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j]==1) queue.add(new int[]{i,j});
            }
        }
        bfs();
        int max = 0;
        boolean isIc = true;
        for(int i = 0;i<cols;i++){
            for(int j = 0;j<rows;j++){
                if(map[i][j]==0){
                    isIc = false;
                    break;
                }
                if(max < map[i][j]){
                    max = map[i][j];
                }

            }
        }
        if(!isIc){
            System.out.println(-1);
        }else{
            System.out.println(max-1);
        }

    }
    /*
    BFS문제로서 지도상에 영역을 표시해나가는 문제이다.
    이 문제에 핵심은 기존의 BFS와는 달리 미리 큐에다가 시작해야할 좌표지점을 넣어두고 BFS를 돌린다.
    여기서 추가적으로 같은 날짜에 익은 토마토라는걸 입증하기 위해서 날짜가 같은걸 표시해야하는데
    이는 이전까지 익은 토마토의 원소값에서 +1을 하면할수록 모든 방향에 같은 날짜로 익은 토마토의 날짜가 표시된다.
    * */
}
