import java.io.*;
import java.util.*;
public class b7562 {
    static int sy;
    static int sx;
    static boolean [][] v;
    static int ty;
    static int tx;
    static int l;
    static int [] dy = {-2,-1,-2,-1,1,2,1,2};
    static int [] dx = {-1,-2,1,2,-2,-1,2,1};
    static StringTokenizer stk;
    static int time;
    static StringBuilder sb =new StringBuilder();
    static void bfs(int i, int j){
        Queue<int []> queue =new LinkedList<>();
        queue.add(new int[]{i,j,0});
        v[i][j] = true;
        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int k = 0;k<8;k++){
                int ny = now[0]+dy[k];
                int nx = now[1]+dx[k];
                if(ny>=l || ny<0 || nx>=l || nx<0) continue;
                if(!v[ny][nx]){
                    v[ny][nx]= true;
                    int [] t = new int[]{ny, nx, now[2]+1};
                    if(ny == ty && nx == tx){
                        time = t[2];
                        break;
                    }
                    queue.add(t);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int t=1;t<=T;t++){
            l = Integer.parseInt(bf.readLine());
            stk = new StringTokenizer(bf.readLine());
            sy = Integer.parseInt(stk.nextToken());
            sx = Integer.parseInt(stk.nextToken());
            stk = new StringTokenizer(bf.readLine());
            ty = Integer.parseInt(stk.nextToken());
            tx = Integer.parseInt(stk.nextToken());
            v = new boolean[l][l];
            time = 0;
            if(sy == ty && sx == tx){
                sb.append(0).append("\n");
            }else {
                bfs(sy, sx);
                sb.append(time).append("\n");
            }
        }
        System.out.print(sb);
    }
}
