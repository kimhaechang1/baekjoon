import java.util.*;
import java.io.*;
public class b2651 {
    static int N;
    static int M;
    static int [] m;
    static int [] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        // 진짜 어렵네
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        m = new int[M+2];
        arr = new int[M+1];
        // N 크기때문에 부분집합으로 풀 수 없음
        // 점화식 유도해야 할 듯
        stk = new StringTokenizer(bf.readLine());
        for(int i= 1;i<M+2;i++){
            m[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i= 1;i<M+1;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int cnt = 0;
        if(N == 0){
            return;
        }else{

            int [] dp = new int[M+2];
            dp[0] = 0;
            // 전처리
            // 전처리 단계에서 얼마나 갈 수 있는지 처리한다.
            int idx2 = 0;
            int init = 0;
            ArrayList<Integer> selected = new ArrayList<>();
            q : while(true){
                int sum = 0;
                cnt++;
                //System.out.println("시작점 : "+idx2);
                ArrayList<Integer> list = new ArrayList<>();
                if(idx2 == M+1) break q;

                while(sum+m[++idx2]  <= N){
                    if(idx2 == M+1){
                        break q;
                    }
                    list.add(idx2);
                    sum+=m[idx2];
                }
                //System.out.println(list.size());
                //System.out.println(list.get(0));
                //System.out.println(list.get(1));
                int min = Integer.MAX_VALUE;
                int minIdx = -1;
                while(list.size()!=0){
                    //System.out.println(dp[init]+arr[list.get(0)]);
                    if(min > dp[init]+arr[list.get(0)]){
                        minIdx = list.get(0);
                        min = dp[init] + arr[list.get(0)];
                    }else if(min == dp[init]+arr[list.get(0)]){
                        minIdx = idx2-1;
                        min = dp[init]+arr[idx2-1];
                    }
                    list.remove(0);
                }
                dp[minIdx] = min;
                //System.out.println("최적의 해 :"+dp[minIdx]+ "선택한 정비소 번호 : "+minIdx);
                selected.add(minIdx);
                idx2 = minIdx;
                init = minIdx;
            }
            //System.out.println("-------------result--------------");
            System.out.println(dp[init]);
            System.out.println(selected.size());
            for(int a: selected) System.out.print(a+" ");
        }
    }
}
