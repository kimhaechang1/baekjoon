import java.util.*;
import java.io.*;
public class b1780 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    static StringTokenizer stk;
    static int [][] map;
    static int K;
    static void dfs(int sy, int sx, int width) {
        int flag = map[sy][sx];
        boolean isAll = true;
        int count = 0;
        L : for(int i= sy;i<sy+width;i++) {
            for(int j = sx;j<sx+width;j++) {
                if(map[i][j] == flag) {
                    count++;
                }else {
                    isAll = false;
                    break L;
                }
            }
        }

        if(isAll) {

            if(flag == 1) {
                plus += (count/(width*width));
                return;
            }else if(flag == -1) {
                minus += (count/(width*width));
                return;
            }else {
                zero +=(count/(width*width));
                return;
            }
        }
        int divde = width/3;
        // 명확하게 다음것을 탐색하게 하기 위해서는 for문을돌려서 재귀호출 하는것은 중첩될 가능성이 크다.
        dfs(sy, sx, divde);
        dfs(sy, sx+divde, divde);
        dfs(sy, sx+(divde*2), divde);

        dfs(sy+divde, sx, divde);
        dfs(sy+divde, sx+divde, divde);
        dfs(sy+divde, sx+(divde*2), divde);

        dfs(sy+(divde*2), sx, divde);
        dfs(sy+(divde*2), sx+divde, divde);
        dfs(sy+(divde*2), sx+(divde*2), divde);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        map = new int[K][K];
        for(int i = 0;i<K;i++) {
            stk = new StringTokenizer(bf.readLine());
            for(int j =0;j<K;j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        if(K == 1) {
            if(map[0][0] == 1) {
                plus = 1;
            }else if(map[0][0] == -1) {
                minus = 1;
            }else {
                zero = 1;
            }
        }else {
            dfs(0,0,K);
        }

        System.out.println(minus);
        System.out.println(zero);
        System.out.print(plus);

    }
}
