import java.util.*;
import java.io.*;
public class b6987_2 {
    static int [] t1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int [] t2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static int [][] result;
    static int [][] map;
    static int res;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        // 결국 월드컵의 원리는 다음과 같다.
        // 월드컵의 경기당 총 라운드수는 15경기이다.
        // 왜냐하면 첫 팀과 자기자신을 제외한 팀과의 경기를 치르고
        // 두번째 팀을 기준으로도 자기자신과 자기자신 전 번째의 경기는 이미 치뤘으므로 무시한다.
        // 그래서 총 15 경기이다.
        // 그리고 한팀당 가질수 있는 경우가 이기거나 지거나 무승부거나 밖에없다.
        // 따라서 부분집합이 가능하다.
        // 어짜피 정해진 나라의 수가 있고 경기 순서가 있기 때문에 미리 출전 목록을 작성해도 된다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new int[6][3];
        result = new int[6][3];
        for(int i= 0;i<4;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<6;j++){
                for(int k = 0;k<3;k++){
                    map[j][k] = Integer.parseInt(stk.nextToken());
                }
            }
            res = 0;
            dfs(0);
            sb.append(res).append(" ");

        }
        System.out.println(sb);
    }
    static void dfs(int round){
//        for(int i= 0;i<6;i++){
//            for(int j = 0;j<3;j++){
//                if(map[i][j] < result[i][j]){
//                    return;
//                }
//            }
//        }
        if(round == 15){
            for(int i= 0;i<6;i++){
                for(int j= 0;j<3;j++){
                    if(map[i][j] != result[i][j]){
                        return;
                    }
                }
            }
            res = 1;
            return;
        }

        result[t1[round]][0]++;
        result[t2[round]][2]++;
        dfs(round+1);
        result[t1[round]][0]--;
        result[t2[round]][2]--;

        result[t2[round]][0]++;
        result[t1[round]][2]++;
        dfs(round+1);
        result[t2[round]][0]--;
        result[t1[round]][2]--;

        result[t2[round]][1]++;
        result[t1[round]][1]++;
        dfs(round+1);
        result[t2[round]][1]--;
        result[t1[round]][1]--;
    }

}
