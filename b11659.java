import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11659 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int qnum = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        int []a = new int[N+1];
        int []r = new int[N+1];
        int []ans = new int[qnum];
        for(int i = 1;i<N+1;i++){
            a[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i = 1;i<N+1;i++){
            r[i] = r[i-1]+a[i];
        }
        for(int i = 0;i<qnum;i++){
            stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            ans[i] = r[end]-r[start-1];
        }
        for(int k: ans) System.out.println(k);
    }
}
