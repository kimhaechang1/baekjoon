import java.util.*;
import java.io.*;
public class b1149 {
    static int N;
    static int [][] map;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][3];
        for(int i = 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<3;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [][] dp = new int[N+1][3];
        // 하나의 집당 3가지의 물감 선택지가 있다.-> 0번 : 빨강, 1번 : 초록, 2번, 파랑
        // 그리고 하나의 집을 하나의 물감으로 선택했다면, 다음 집의 색 선택지가 2개로 좁혀진다.
        // 이 때, 어떤 색으로 선택하냐에 따라 비용이 겹치는 순간이 있다. 그 전집과 동일한 색은 선택하지 못하기 때문에
        // 예를들어 맨 첫번째 집을 빨간색(0)으로 선택한다면, 두번째 집은 초록(1) or 파랑(2)이 있게되고
        // 맨 첫번째 집을 초록으로 정한다면 빨강(0), 파랑(2)이 있게 된다.
        // 이 때 현재까지 선택한 비용에서 서로 겹치는 부분에 대하여(위의 예시에서 파랑), 더 적은 비용의 경우만을 유용한 후보로 내려보낸다면
        // 마지막집에서 처음에 선택한 색의 최종 최소비용이 나올 것 이고, 3가지 색에대한 최소비용들 중 최솟값을 가지는 것이 정답이 된다.

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        for(int i= 0;i<N-1;i++){
            // 일단 빨강을 기준으로 다음 선택지를 처리한다.
            dp[i+1][1] = map[i+1][1]+dp[i][0];
            dp[i+1][2] = map[i+1][2]+dp[i][0];
            // 그런 다음 만약 초록을 선택했을 때를 처리한다. 이 때 빨강과 겹치는부분은 더 최소비용만을 기록한다.
            dp[i+1][0] = map[i+1][0]+dp[i][1];
            if(dp[i+1][2] > map[i+1][2]+dp[i][1]){
                dp[i+1][2] = map[i+1][2]+dp[i][1];
            }
            // 마지막으로 파랑을 선택한 경우를 처리한다.
            // 파랑을 선택했으면 빨강을 선택했을때의 선택지와 겹치고, 초록을 선택했던 선택지와 겹친다.
            if(dp[i+1][1] > map[i+1][1] + dp[i][2]){
                dp[i+1][1] = map[i+1][1] + dp[i][2];
            }
            if(dp[i+1][0] > map[i+1][0]+dp[i][2]){
                dp[i+1][0] = map[i+1][0]+dp[i][2];
            }
        }
        // 이제 dp배열의 마지막층에 최초선택지를 어떻게 하느냐에 따른 최소비용이 저장되어있으므로
        // 헤당 배열의 원소중 최솟값을 출력하면 된다.
        Arrays.sort(dp[N-1]);
        System.out.println(dp[N-1][0]);
    }
}
