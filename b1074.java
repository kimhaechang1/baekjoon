import java.util.*;
import java.io.*;
public class b1074 {
    static int N;
    static int R;
    static int C;
    static int length;
    static int res;
    static StringTokenizer stk;
    static void dfs(int y, int x, int len){
        if(len == 1){
            System.out.println(res);
            return;
        }
        int halfLen = len/2;
        if(y+halfLen > R && x+halfLen > C){
            dfs(y, x,  halfLen );
        }else if(y+halfLen>R && x+halfLen<=C){
            res += ((len*len)/4);
            dfs(y,x+halfLen,halfLen);
        }else if(y+halfLen<=R && x+halfLen>C ){
            res += ((len*len)/4)*2;
            dfs(y+halfLen,x, halfLen);
        }else if(y+halfLen<=R && x+halfLen<=C){
            res += ((len*len)/4)*3;
            dfs(y+halfLen,x+halfLen, halfLen);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        length = (int)Math.pow(2,N);
        res =0;
        dfs(0,0,length);
    }
}
