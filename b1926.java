import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class b1926 {
    static int count = 2;

    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static int rows;
    static int cols;
    static int [][] map;
    static int dt = 0;
    static String [] buffer;
    static void bfs(int y, int x){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            map[now[0]][now[1]] = count;
            dt++;
            for(int i= 0;i<4;i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny > -1 && ny< cols && nx > -1 && nx< rows && map[ny][nx]==1){
                    queue.add(new int[]{ny,nx});
                    map[ny][nx] = count;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        buffer = bf.readLine().split(" ");
        rows = Integer.parseInt(buffer[1]);
        cols = Integer.parseInt(buffer[0]);
        map = new int[cols][rows];
        int max = 0;
        for(int i = 0;i<cols;i++){
            String temp = bf.readLine();
            buffer = temp.split(" ");
            for(int j = 0;j<rows;j++){
                map[i][j] = Integer.parseInt(buffer[j]);
            }
        }

        for(int i= 0;i<cols;i++){
            for(int j =0;j<rows;j++){
                if(map[i][j]== 1){
                    dt = 0;
                    bfs(i,j);
                    count++;
                    if(max < dt) max = dt;
                }
            }
        }
       System.out.println(count - 2);
       System.out.println(max);

    }
    // 지도 상에 영역을 표시하는 문제 ->  대부분 BFS로 해결가능한 문제이다.
    // 지도가 나왔고 영역을 표시해야 한다면, 방향벡터를 정의 및 큐에 좌표를 넣는 생각(int []{y, x})
    // 그리고 나아갈수있는지 검증 후 큐에 넣는다는 것을 생각해야한다.

}
