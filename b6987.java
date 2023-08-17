import java.util.*;
import java.io.*;
public class b6987 {
    static int [][] arr;
    static int [][] map;
    static StringTokenizer stk;
    static int res;

    public static void main(String[] args) throws Exception{
        // 각 나라별 승, 무승부, 패 세가지 경우의 수 가 있다.
        // 소속된 국가들은 한번씩 각 국가별로 5번의 경기를 치른다.
        // 가능한 결과인지 파악한다.
        // 각 나라별 승, 무, 패 일때의 모든 경우를 확인하여 대조한다.
        // 일단 모든 나라의 승, 무 패 의 합이 30이어야 한다.
        // 3가지 종류 중 하나여야 하므로 부분집합으로 생각할 수 있다.
        // A~F까지 서로 한번씩만 경기한다고 하였을 때
        // A는 5번 B는 4번 등등 결국 총 경기수는 15경기이다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 4;
        for(int t= 1;t<=T;t++){
            stk = new StringTokenizer(bf.readLine());
            arr = new int[6][3];
            int sum = 0;
            for(int i = 0;i<6;i++){
                for(int j = 0;j<3;j++){
                    arr[i][j] = Integer.parseInt(stk.nextToken());
                    sum+=(arr[i][j]);
                }
            }
            res = 0;
            map = new int[6][3];
            if(sum == 30){
                dfs(0,1);
            }
            System.out.print(res+" ");
        }
    }
    static void dfs(int t1, int t2){
        if(t1 == 5 && t2 == 6){
            if(check()){
                res= 1;
            }
            return;
        }
        for(int i= 1;i<=3;i++ ){
            // 모든 나라는 3가지의 경우의수를 갖는다.
            // 모든경우의 수에 따른 점수결과판을 가지고서 결판을 치른다.
            int nt1 = t1;
            int nt2 = t2+1;
            if(t2 == 5){
                nt1 = nt1+1;
                nt2 = nt1+1;
            }
            if(i == 1){
                map[t1][0]++;
                map[t2][2]++;
            }else if(i == 2){
                map[t1][1]++;
                map[t2][1]++;
            }else{
                map[t1][2]++;
                map[t2][0]++;
            }
            dfs(nt1,nt2);
            if(i == 1){
                map[t1][0]--;
                map[t2][2]--;
            }else if(i == 2){
                map[t1][1]--;
                map[t2][1]--;
            }else{
                map[t1][2]--;
                map[t2][0]--;
            }
        }

    }
    static boolean check(){
        for(int i=0;i<6;i++){
            for(int j = 0;j<3;j++){
                if(map[i][j] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
