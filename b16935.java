import java.util.*;
import java.io.*;

public class b16935 {
    static int N;
    static int M;
    static int R;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(bf.readLine());

        for(int i = 0;i<R;i++){
            int c = Integer.parseInt(stk.nextToken());
            switch(c){
                case 1 :{
                    func1();
                    break;
                }
                case 2 :{
                    func2();
                    break;
                }
                case 3:{
                    func3();
                    break;
                }
                case 4:{
                    func4();
                    break;
                }
                case 5 : {
                    func5();
                    break;
                }
                case 6 :{
                    func6();
                    break;
                }
            }

        }
        for(int j= 0;j<N;j++){
            for(int k =0;k<M;k++){
                System.out.print(map[j][k]+" ");
            }
            System.out.println();
        }
    }
    static void func1(){
        int [][] temp = new int[N][M];
        for(int i= 0;i<N;i++){
            for(int j= 0;j<M;j++){
                temp[N-i-1][j] = map[i][j]; // 위아랫줄 서로 교환
            }
        }
        map = temp;
    }
    static void func2(){

        int [][] temp = new int[N][M];

        for(int i= 0;i<N;i++){
            for(int j = 0;j<M;j++){
                temp[i][M-1-j] = map[i][j]; // 왼 오 교환
            }
        }
        map = temp;
    }
    static void func3(){
        int [][] temp = new int[M][N];
        for(int i= 0;i<N;i++){
            for(int j = 0;j<M;j++){
                temp[j][N-1-i] = map[i][j]; // 원본기준 가장 아랫줄을 생각해보면
                                            // 젤 오른쪽끝이 왼쪽 앞으로 올라오며 그런 아랫줄을 밑변을 세운단 느낌으로 가야한다.
            }
        }
        int t = N;
        N = M;
        M = t;
        map = temp;
    }
    static void func4(){
        int [][] temp = new int[M][N];
        for(int i= 0;i<N;i++){
            for(int j = 0;j<M;j++){
                temp[M-1-j][i] = map[i][j]; // 원본기준 가장 윗줄을 생각해보면
                // 젤 왼쪽끝이 왼쪽 아래로 내려오며 
            }
        }
        int t = N;
        N = M;
        M = t;
        map = temp;
    }
    static void func5(){
        int [][] temp = new int[N][M];
        // G1 -> G2
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[i][M/2+j] = map[i][j];
            }
        }
        // G2 -> G3
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[N/2+i][M/2+j] = map[i][M/2+j];
            }
        }
        // G3 -> G4
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[N/2+i][j] = map[N/2+i][M/2+j];
            }
        }
        // G4 -> G1
        for(int i= 0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                temp[i][j] = map[N/2+i][j];
            }
        }

        map = temp;
    }
    static void func6(){
        int [][] temp = new int[N][M];
        // G2 -> G1
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[i][j] = map[i][M/2+j];
            }
        }
        // G1 -> G3
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[N/2+i][j] = map[i][j];
            }
        }
        // G3 -> G4
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[N/2+i][M/2+j] = map[N/2+i][j];
            }
        }
        // G4 -> G2
        for(int i= 0;i<N/2;i++){
            for(int j = 0;j<M/2;j++){
                temp[i][M/2+j] = map[N/2+i][M/2+j];
            }
        }
        map = temp;
    }

}
