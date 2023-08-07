import java.util.*;
import java.io.*;
public class b1074 {
    static int N;
    static int R;
    static int C;
    static StringTokenizer stk;
    static int result = 0;
    // 숫자들의 위치패턴이 2^n승에서 4개의 분면으로 동일하게 나타난다.
    // 따라서 4개의 분면으로 나누고 내가 찾으려는 행과 열이 포함되어있는 곳에서 재귀를 실행하면 된다.
    // 그러면 최종적으로 한칸이 잡히는 순간이 있을텐데, 그 때가 정답이 된다.
    static void dfs(int sy, int sx, int width) {
        if(width == 1) {
            System.out.println(result);
            return;
        }
        int s = width/2;
        if(R <sy+s && C <sx + s) {

            dfs(sy, sx, s);
        }else if(R <sy+s && sx+s<=C) {
            result += (width*width)/4;
            dfs(sy, sx+s, s);
        }else if(R >=sy+s && sx+s>C) {
            result += ((width*width)/4)*2;
            dfs(sy+s, sx, s);
        }else if(R >=sy+s && sx+s<=C) {
            result += ((width*width)/4)*3;
            dfs(sy+s,sx+s,s);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        int width = (int)Math.pow(2, N);
        int total = (width * width)-1;
        dfs(0,0,width);
    }
}
