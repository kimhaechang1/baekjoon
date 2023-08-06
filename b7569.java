import java.util.*;
import java.io.*;
public class b7569 {
    static StringTokenizer stk;
    static int [][][]map;
    static int H; // 높이
    static int N; // 세로
    static int M; // 가로
    static int time = 0;
    static int preUn = 0; // 전에 덜익은 사과의 개수
    static int [] dh = {1,-1,0,0,0,0};
    static int [] dy = {0,0,-1,0,1,0};
    static int [] dx = {0,0,0,-1,0,1};
    static boolean [][][]v;
    static int ic = 0;
    static int no = 0;
    static Queue<int[]> queue = new LinkedList<>();
    static void bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int k= 0;k<6;k++){
                int nh = now[0] + dh[k];
                int ny = now[1] + dy[k];
                int nx = now[2] + dx[k];
                if(nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[nh][ny][nx] == 0){
                    map[nh][ny][nx] = map[now[0]][now[1]][now[2]]+1;
                    queue.add(new int[]{nh,ny,nx});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine(), " ");
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());
        map = new int[H][N][M];
        for(int i= 0;i<H;i++){
            for(int j = 0;j<N;j++){
                stk = new StringTokenizer(bf.readLine(), " ");
                for(int k = 0;k<M;k++){
                    map[i][j][k] = Integer.parseInt(stk.nextToken());
                    if(map[i][j][k] == 1){
                        // 모든 익은 토마토들에게서 동시다발적으로 익기 시작
                        queue.add(new int[]{i,j,k});
                        ic++;
                    }else if(map[i][j][k]==0){
                        preUn++;
                    }else{
                        no++;
                    }
                }
            }
        }
        int result = 0;
        v = new boolean[H+1][N+1][M+1];
        int unic = 0;
        if(preUn > 0){
                bfs();
                for(int i= 0;i<H;i++){
                    for(int j = 0;j<N;j++){
                        for(int k = 0;k<M;k++){
                            if(map[i][j][k] == 0){
                                unic++;
                            }
                            if(map[i][j][k] > time){
                                time = map[i][j][k];
                            }
                        }
                    }
            }

        }
        if(unic > 0){
            result = -1;
        }else if(unic == 0 && preUn !=0){
            result = time-1;
        }else if(no == N*M*H){
            result = -1;
        }
        System.out.println(result);
    }
}
