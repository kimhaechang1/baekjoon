import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b10026 {
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static char state;
    static int count;
    static int abCount;
    static int n;
    static char [][] map;
    static char [][] abMap;
    static void bfs(char state, int y, int x, char [][] map){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        if(state == 'R') map[y][x] = 'r';
        else if(state == 'G') map[y][x] = 'g';
        else map[y][x] = 'b';
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int i = 0;i<4;i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny > -1 && ny<n && nx > -1 && nx<n && map[ny][nx] == state){
                    map[ny][nx] = map[y][x];
                    queue.add(new int[]{ny,nx});
                }
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        abMap = new char[n][n];
        for(int i= 0;i<n;i++){
            String temp = bf.readLine();
            for(int j = 0;j<n;j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'G'){
                    abMap[i][j] = 'R';
                }else{
                    abMap[i][j] = map[i][j];
                }
            }
        }
        count = 0;
        abCount = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == 'R' || map[i][j] == 'G' ||  map[i][j] == 'B'){
                    bfs(map[i][j], i, j, map);
                    count++;
                }
                if(abMap[i][j] == 'R' || abMap[i][j] == 'B'){
                    bfs(abMap[i][j], i, j, abMap);
                    abCount++;
                }
            }
        }
        System.out.println(count +" "+ abCount);

    }
}
