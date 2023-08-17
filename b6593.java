import java.util.*;
import java.io.*;

public class b6593 {
    static char [][][]map;
    static boolean [][][]v;
    static int L;
    static int R;
    static int C;
    static StringTokenizer stk;
    static int [] dy = {-1,0,1,0,0,0};
    static int [] dx = {0,-1,0,1,0,0};
    static int [] dh = {0,0,0,0,1,-1};
    static Queue<int[]> queue;
    static int time;
    static boolean bfs(){
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k= 0;k<6;k++){
                int nh = now[0]+dh[k];
                int ny = now[1]+dy[k];
                int nx = now[2]+dx[k];
                if(nh >= L || nh < 0 || ny >= R || ny<0 || nx>=C || nx<0 || v[nh][ny][nx]) continue;
                if(map[nh][ny][nx] == 'E'){
                    time = now[3]+1;
                    return true;
                }
                else if (map[nh][ny][nx] == '.') {
                    map[nh][ny][nx] = 'S';
                    queue.add(new int[]{nh,ny,nx, now[3]+1});
                    v[nh][ny][nx] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        // 최단거리 즉, BFS
        // 동서남북상하 즉 3차원 map이다.
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        while(true){
            stk = new StringTokenizer(bf.readLine());
            L = Integer.parseInt(stk.nextToken());
            R = Integer.parseInt(stk.nextToken());
            C = Integer.parseInt(stk.nextToken());
            if(L+R+C == 0) break;
            map = new char[L][R][C];
            v = new boolean[L][R][C];
            queue = new LinkedList<>();
            time = 0;
            for(int i= 0;i<L;i++) {
                for (int j = 0; j < R; j++) {
                    String t = bf.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = t.charAt(k);
                        if (map[i][j][k] == 'S') {
                            queue.add(new int[]{i, j, k, 0});
                            v[i][j][k] = true;
                        }
                    }
                }
                bf.readLine();
            }
            if(bfs()){
                System.out.printf("Escaped in %d minute(s).\n", time);
            }else{
                System.out.println("Trapped!");
            }
        }
    }
}
