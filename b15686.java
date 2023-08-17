import java.util.*;
import java.io.*;

public class b15686 {
    static int [][] map;
    static boolean [] res;
    static Data [] house;
    static Data [] chicken;
    static int N;
    static int M;
    static StringTokenizer stk;
    static int min;
    static class Data{
        int y;
        int x;
        public Data(int y , int x) {
            this.y = y;
            this.x = x;
        }
    }
    static void dfs(int depth, int cnt){
        if(depth >= chicken.length){ // 겁나 선택안하다가 갑자기 선택을 할수도 있음, 그래서 depth는 솔직히 몇이될지 체감이 안된다
            if(cnt > 0 && cnt <=M){ // 공집합 제외
                int sum1 = 0;
                for(int i= 0;i<house.length;i++){
                    Data h = house[i];
                    int d = 99999999;
                    for(int j= 0;j< chicken.length;j++){
                        if(res[j]){
                            int di = Math.abs(h.y - chicken[j].y)+ Math.abs(h.x - chicken[j].x);
                            if(d > di) d = di;
                        }
                    }
                    sum1+=d;
                }
                if(min > sum1){
                    min = sum1;
                }
            }
            return;
        }
        res[depth] = true;
        dfs(depth+1, cnt+1);
        res[depth] = false;
        dfs(depth+1, cnt);
    }

    public static void main(String[] args) throws Exception{
        // 부분집합으로 어떤 치킨집을 사용할지 구한다.
        // 공집합의 경우는 제외한다.
        // 치킨거리는 각 집에서부터 가장 가까운 치킨집까지의 거리이다.
        // 치킨집이 두개이상인 경우 집에서부터 각 치킨집까지의 거리중 최소가 해당 집의 치킨거리가되고
        // 이러한 치킨거리들의 합을 구하면 현재 상황에서의 도시의 치킨거리가 된다.
        // 이러한 도시의 치킨거리중 최솟값을 구하면 끝
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][N];
        int cc =0;
        int hc = 0;
        for(int i= 0;i<N;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j = 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 1){
                    hc++;
                }else if(map[i][j] == 2){
                    cc++;
                }
            }
        }
        chicken = new Data[cc];
        house = new Data[hc];
        int idx1 = 0;
        int idx2 = 0;
        for(int i= 0;i<N;i++){
            for(int j= 0;j<N;j++){
                if(map[i][j] == 1){
                    house[idx1++] = new Data(i,j);
                }else if(map[i][j] == 2){
                    chicken[idx2++] = new Data(i,j);
                }
            }
        }
        res = new boolean[cc];
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min);
    }
}
