import java.util.*;
import java.io.*;
public class b14499 {
    static int N;
    static int M;
    static int ty;
    static int tx;
    static int K;
    static int [][] map;
    static int [][] arr;
    static int [] query;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        tx = Integer.parseInt(stk.nextToken());
        ty = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        // 지도의 오른쪽은 동쪽 위쪽은 북쪽
        // 바깥으로 이동하려하면 출력도 하면안되고 해당명령을 무시해야 한다.
        // 이동한 칸에 쓰여있는수가 0이면 바닥면에 쓰여있는 수가 복사됨
        // 0이 아니면 지도에 쓰인 수가 주사위 바닥면으로 복사됨
        // 초창기 주사위의 상태는 윗 : 1, 동 : 3, 서 : 4, 앞 : 5, 아래 : 6 이다.
        //


    }
}
