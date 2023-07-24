import java.io.*;
import java.util.*;
public class b1182 {
    static int [] arr;
    static StringTokenizer stk;
    static int N;
    static int S;
    static int count = 0;
    static void dfs(int depth, int presentSum){
        if(depth == N) {
            if (presentSum == S) {
                count++;
            }
            return;
        }
        dfs(depth+1, presentSum+arr[depth]);
        dfs(depth+1, presentSum);
    }
    public static void main(String[] args) throws Exception{
        // 부분수열 부분집합 문제
        // 집합의 경우에는 공집합의 경우를 생각하자(만약 양수인 부분수열이란 말이 있으면 공집합 하나 빼줘야함)
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(bf.readLine(), " ");
        count = 0;
        for(int i= 0;i<N;i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(0,0);
        if(S == 0) System.out.println(count-1); // 공집합의 경우도 0으로 치는것을 방지하기 위함
        else System.out.println(count);
    }
}
