import java.util.*;
import java.io.*;
public class b2615 {
    static int [] dy = {-1,0,1,1};
    static int [] dx = {1,1,1,0};
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        for(int i = 0;i<19;i++){
            stk = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0;j<19;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int whoWin = 0;
        int [] xy = new int[2];
        for(int i= 0;i<19;i++){
            for(int j = 0;j<19;j++){
                if(map[i][j] !=0){

                    for(int k = 0;k<4;k++){
                        int ny = i;
                        int nx = j;
                        boolean sign = true;
                        for(int p = 0;p<5;p++) {
                            if ((ny < 0 || ny >= 19 || nx < 0 || nx >= 19) || (map[ny][nx] != map[i][j])) {
                                sign = false;
                                break;
                            }
                            ny += dy[k];
                            nx += dx[k];

                        }
                        if(sign){
                            if((ny <0  || ny>=19 || nx < 0 || nx>=19 || map[ny][nx] !=map[i][j]) &&
                                    (i-dy[k] <0  || i-dy[k]>=19 || j-dx[k] < 0 || j-dx[k]>=19 || map[i-dy[k]][j-dx[k]] !=map[i][j])){
                               xy[0] = ny;
                               xy[1] = nx;
                               System.out.println(map[i][j]);
                               System.out.println((i+1)+" "+(j+1));
                               return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(whoWin);
    }
}
