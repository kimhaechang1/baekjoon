import java.util.*;
import java.io.*;

public class b17136 {
    static final int N = 10;
    static int [][]map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];

        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

    }
}
