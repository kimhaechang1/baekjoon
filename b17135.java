import java.util.*;
import java.io.*;
public class b17135 {
    static int [][] map;
    static int N;
    static int M;
    static int D;
    static StringTokenizer stk;
    static int [][] status ;
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        map = new int[N+1][M]; // 궁수들은 항상 가장 아래쪽 줄
        for(int i = 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<M;j++){
                map[i][j]= Integer.parseInt(stk.nextToken());

            }
        }
        int [] comb =   new int[M];
        Arrays.fill(comb, M-3,M,1);
        max = Integer.MIN_VALUE;
        do{
            status = new int[3][3];
            int [][] temp = new int[N+1][M];
            for(int i=0;i<N+1;i++){
                temp[i] = Arrays.copyOf(map[i], map[i].length);
            }
            int idx = 0;
            for(int i= 0;i<comb.length;i++){
                if(comb[i] == 1){
                    status[idx][0] = N;
                    status[idx][1] = i;
                    status[idx++][2] = 0;
                    temp[N][i] = i+1;
                }
            }
            int count = 0;
            for(int n= 0;n<N;n++){
                boolean [][] v = new boolean[N+1][M];
                for(int i = 0;i<3;i++) {
                    int gy = status[i][0];
                    int gx = status[i][1];
                    int minD = Integer.MAX_VALUE;
                    int minY = Integer.MAX_VALUE; // 최종 좌표
                    int minX = Integer.MAX_VALUE; // 최종 좌표
                    for (int j = N - 1; j > -1; j--) {
                        for (int k = 0; k < M; k++) {
                            if (temp[j][k] == 1) {
                                int d1 = Math.abs(gy - j) + Math.abs(gx - k);
                                if (minD > d1) {
                                        minD = d1;
                                        minY = j;
                                        minX = k;

                                }else if(minD == d1 && minX > k){
                                        minY = j;
                                        minX = k;

                                }
                            }
                        }
                    }
                    if(D >= minD){
                        // 마지막에 최단거리가 진짜 합법적인 최단거리인지 검사
                        v[minY][minX] = true;
                    }
                }

                    for(int i = 0;i<N;i++) {
                        for (int j = 0; j < M; j++) {
                            if (v[i][j]) {
                                temp[i][j] = 0;
                                count++;
                            }
                        }
                    }
                    for(int i = 0;i<M;i++){
                        temp[N-1][i] = 0;
                    }
                    for(int i = N-1;i>0;i--){
                        for(int j = 0;j<M;j++){
                            temp[i][j] = temp[i-1][j];
                        }
                    }
                for(int i = 0;i<M;i++){
                    temp[0][i] = 0;
                }

                //System.out.println(Arrays.deepToString(temp));
                }

                if(count > max){
                    max = count;
                }



        }while(np(comb));
        System.out.println(max);
    }
    static boolean np(int [] arr){
        int i= arr.length-1;
        while(i > 0 && arr[i-1] >= arr[i]) i--;
        if(i == 0 )return false;
        int j= arr.length-1;
        while(arr[i-1]>=arr[j]) j--;
        int t= arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = t;
        int k = arr.length-1;
        while(i<k){
            t= arr[k];
            arr[k] = arr[i];
            arr[i] = t;
            i++;
            k--;
        }
        return true;
    }

}
