import java.util.*;
import java.io.*;
public class b1476 {
    static int E;
    static int S;
    static int M;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int year = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        stk = new StringTokenizer(bf.readLine());
        E = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        while(true){

            if(e == 16){
                e =1;
            }
            if(s == 29){
                s = 1;
            }
            if(m == 20){
                m = 1;
            }
            if(e == E && s == S && m == M)break;
            e++;s++;m++;year++;
        }
        System.out.println(year);

    }
}
