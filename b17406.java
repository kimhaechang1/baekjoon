import java.util.*;
import java.io.*;
public class b17406 {
    static int [][] arr;
    static int [][] map;
    static boolean [] v;
    static int [][] res;
    static int min;
    static int N;
    static int M;
    static int K;
    static StringTokenizer stk;
    static void dfs(int depth){
        if(depth == K){
            // 뽑은 순열에 있는 값들을 이용해서 배열을 순열에 맞춰서 돌리고
            // 각 행별로 합의 최솟값을 구해서 해당 배열의 값을 찾고 min값 갱신
            // 각 경우의수는 독립적으로 계산되어야 하므로 임시배열에 복사해놓음
            int [][] tmp = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j= 0;j<M;j++){
                    tmp[i][j]=map[i][j] ;
                }
            }
            // 나온 경우의수 만큼 반복
            for(int i= 0;i<K;i++){
                // 각 좌표들이 실제로 배열의 인덱스에 적용하는 값보다 1씩 더 크므로 빼줌
                int y1 = res[i][0]-res[i][2]-1;
                int x1 = res[i][1]-res[i][2]-1;
                int y2 = res[i][0]+res[i][2]-1;
                int x2 = res[i][1]+res[i][2]-1;
                // 실제로 반복해야 하는 횟수는 가로세로 길이 중 더 작은값에 나누기 2를 한 것에 해당함
                int count = Math.min(y2-y1+1, x2-x1+1)/2;
                for(int c = 0; c<count;c++) {
                    // 왼쪽 모서리 혹은 오른쪽 모서리에서 부터 시작하므로 해당 값을 임시저장
                    int temp = tmp[y1 + c][x1 + c];
                    // 왼쪽의 값들은 위로 올라가므로 세로기준 더 큰 인덱스번호에서 작은 인덱스번호로 덮어씌움
                    for (int j = y1 + c; j < y2 - c; j++) {
                        tmp[j][x1 + c] = tmp[j + 1][x1 + c];
                    }
                    // 아래의 값들은 왼쪽으로 가므로 가로기준 더 큰 인덱스 번호들이 작은 인덱스번호로 덮어씌움
                    for (int j = x1 + c; j < x2 - c; j++) {
                        tmp[y2 - c][j] = tmp[y2 - c][j + 1];
                    }
                    // 오른쪽의 값들은 아래로으로 가므로 세로기준 더 작은 인덱스 번호들이 큰 인덱스번호로 덮어씌움
                    for (int j = y2 - c; j > y1 + c; j--) {
                        tmp[j][x2 - c] = tmp[j - 1][x2 - c];
                    }
                    // 위의 값들은 오른쪽으로 가므로 가로기준 더 작은 인덱스 번호들이 큰 인덱스번호로 덮어씌움
                    for (int j = x2 - c; j > x1 + c; j--) {
                        tmp[y1 + c][j] = tmp[y1 + c][j - 1];
                    }
                    // 항상 가로기준 1 더한만큼의 위치가 비게 된다.
                    tmp[y1 + c][x1 + c + 1] = temp;
                }
            }
            // 행들의 최솟값을 저장하기 위한 mini 변수
            int mini = 999999999;
            for(int i =0;i<N;i++){
                int sum = 0;
                for(int j= 0;j<M;j++){
                    sum+=tmp[i][j];
                }
                if(mini > sum){
                    mini = sum;
                }
            }
            // 정답값 갱신
            if(mini < min){
                min = mini;
            }
            return;
        }
        for(int i= 0;i<K;i++){
            if(!v[i]){
                v[i] = true;
                res[depth] = arr[i];
                dfs(depth+1);
                v[i] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        // 순열로 회전연산정보의 가짓수를 찾고 그 가짓수의 순서대로 배열을 회전시킨 후
        // 각 행별로 합을 구해서 그 중에 최솟값을 찾고 그것이 정답과 비교하여 최소인경우 갱신
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        K = Integer.parseInt(stk.nextToken());
        for(int i= 0;i<N;i++){
            stk =  new StringTokenizer(bf.readLine());
            for(int j= 0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        min = 99999999;
        arr = new int[K][3];
        res = new int[K][3];

        for(int i= 0;i<K;i++){
            stk = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
            arr[i][2] = Integer.parseInt(stk.nextToken());
        }
        v = new boolean[K];
        dfs(0);
        System.out.println(min);
    }
}
