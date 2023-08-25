import java.util.*;
import java.io.*;

public class b14503 {
    static int N;
    static int M;
    static int [][] map;
    static int [] dy ={-1,0,1,0}; // 북 동 남 서
    static int [] dx ={0,1,0, -1}; // 초기위치가 동이라면 동 북 서 남 순으로 돌아야한다. 이를 인덱스로 바꾸면 1 0 3 2 가 된다.
    static int d;
    static StringTokenizer stk;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        int sy = Integer.parseInt(stk.nextToken());
        int sx = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        System.out.println(bfs(sy, sx));
//        for(int i= 0;i<N;i++){
//            for(int j = 0;j<M;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static int bfs(int sy, int sx){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{sy,sx});
        int cnt = 1;

        while(!queue.isEmpty()){
            int [] now = queue.poll();
            if(map[now[0]][now[1]] == 0){

                map[now[0]][now[1]] = 2;
            }
            boolean isCan = false;
            for(int k = 0;k<4;k++){
                // 먼저 로봇청소기의 방향을 돌려주고 해당방향에 앞칸에 청소안한칸이 있으면 그기로 움직여야 함
                d -= 1; // 반시계방향 돌기
                if(d < 0) d = 3; // 만약에 음수가 뜬다? 그럼 3부터라는 뜻
                int ny  = now[0] + dy[d];
                int nx  = now[1] + dx[d];
                if(ny >= N || ny < 0 || nx>=M || nx<0 || map[ny][nx] == 1) continue;
                if(map[ny][nx] == 0) {
                    isCan = true;
                    cnt++;
                    map[ny][nx] = 2;
                    queue.add(new int[]{ny, nx});
                    break;
                }
            }
            if(!isCan){
                int hy = now[0] - dy[d];
                int hx = now[1] - dx[d];
                if(hy >=N || hy < 0 || hx >=M || hx< 0 || map[hy][hx] == 1) break;
                queue.add(new int[]{hy, hx});
            }
        }
        return cnt;
    }
}
