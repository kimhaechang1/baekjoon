import java.util.*;
import java.io.*;
public class b16972 {
    static int N;
    static int M;
    static int R;
    static int [][]map;
    static StringTokenizer stk;
    static void push(int [] turn){

        int count = Math.min(N,M)/2;
        for(int c = 0;c<count;c++){
            // 숫자가 돌아오는 경우는 그 숫자가 가로2번 세로 2번을 거쳤을 경우인데
            // 모서리 4번은 중첩될 수 있다.
            // 따라서 외각과 내각 기준으로 미리 몇번 회전해야하는지 계산한 후 (한바퀴 다 도는데 걸리는 횟수를 통한 모듈러 연산을 통해)
            // 정해진 횟수만 돌려버린다.
            for(int k = 0;k<turn[c];k++){
                int temp = map[c][c];
                for(int i=0+c;i<M-1-c;i++){
                    map[0+c][i] = map[0+c][i+1];
                }

                for(int i= 0+c;i<N-1-c;i++){
                    map[i][M-1-c] = map[i+1][M-1-c];
                }

                for(int i = M-1-c;i>0+c;i--){
                    map[N-1-c][i] = map[N-1-c][i-1];
                }

                for(int i = N-1-c;i>0+c;i--){
                    map[i][0+c] = map[i-1][0+c];
                }
                map[c+1][c] = temp;
            }
        }

        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [] turn = new int[Math.min(N,M)/2];
        for(int i=0;i<turn.length;i++){
            turn[i] = R % ((2*(N -2 * i))+(2*(M-2*i))-4);
        }
        push(turn);

    }
}
