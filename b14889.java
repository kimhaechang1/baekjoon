import java.util.*;
import java.io.*;

public class b14889 {
    static int [][] map;
    static StringTokenizer stk;
    static int N;
    static int min;
    public static void main(String[] args) throws Exception{
        // N명은 짝수, N/2로 나누어야함 그 경우의수는 순서는 상관없는거니까 조합
        // 넥퍼로 조합만들면 됨
        // N = 6이면 3 3 으로 쪼개질 수 있고 각각의 경우의 수에서 나올수 있는 시너지 합을 모두 구해서
        // 두 팀의 시너지 차를 구하고 최솟값 갱신
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            stk =new StringTokenizer(bf.readLine());
            for(int j= 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [] comb = new int[N];
        Arrays.fill(comb, N/2, N,1);
        do{
            int sum1 = 0;
            int sum2 = 0;
            for(int i= 0;i<N-1;i++){
                for(int j= i+1;j<N;j++){
                    if(comb[i] == 0 && comb[j] == 0){
                        sum1+= (map[i][j] + map[j][i]);
                    }else if(comb[i] == 1 && comb[j] == 1){
                        sum2 += (map[i][j]+ map[j][i]);
                    }
                }
            }
            int cha = Math.abs(sum1-sum2);
            if(cha < min) min = cha;
        }while(np(comb));
        System.out.println(min);
    }
    static boolean np(int[] arr){
        int i= N-1;
        while(i > 0 && arr[i-1]>=arr[i]) i--;
        if(i==0) return false;
        int j = N-1;
        while(arr[i-1]>=arr[j]) j--;
        int t = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = t;
        int k= N-1;
        while(i < k){
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
            i++;
            k--;
        }
        return true;
    }

}
