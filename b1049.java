import java.util.*;
import java.io.*;

public class b1049 {
    static StringTokenizer stk;
    static int [] six;
    static int [] one;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        // 6개 줄당 가격 또는 1개 줄당 가격
        // 적어도 N개를 사야한다 -> N이상의 줄개수가 되어야한다.
        // 근데 그 금액이 최소가 되어야 한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        six = new int[M];
        one = new int[M];
        for(int i= 0;i<M;i++){
            stk = new StringTokenizer(bf.readLine());
            six[i] = Integer.parseInt(stk.nextToken());
            one[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(six);
        Arrays.sort(one);

        int target = N;
        int res = 0;
        while(target >0){
            // 현재상황에서 패키지 가격으로 최대한 삿을 때 와 낱개로 최대한 삿을때
            // 둘 중 싼 방법으로 산다.
            //six[0] < one[0] *(target)
            int besu = 0;
            if(target >=6){
                besu = 6;
                if(six[0] * (target/6) < one[0] * ((target/6)*besu) ){
                    res += (six[0]);
                    target -= 6;
                }else{
                    res +=(one[0]);
                    target -=1;
                }
            }else{
                besu = target;
                if(six[0]< one[0] *besu){
                    res += (six[0]);
                    target -= 6;
                }else{
                    res +=(one[0]);
                    target -=1;
                }
            }
        }
        System.out.println(res);
    }
}
