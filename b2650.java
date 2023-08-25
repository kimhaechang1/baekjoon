import java.util.*;
import java.io.*;
public class b2650 {
    static int N;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N/2][4];
        for(int i= 0;i<N/2;i++){
            stk = new StringTokenizer(bf.readLine());
            map[i][0] = Integer.parseInt(stk.nextToken());
            map[i][1] = Integer.parseInt(stk.nextToken());
            map[i][2] = Integer.parseInt(stk.nextToken());
            map[i][3] = Integer.parseInt(stk.nextToken());
        }
        // 첫째 정수가 1이면 윗변, 2이면 밑변, 3이면 왼쪽변, 4이면 오른쪽변
        //
    }
}
