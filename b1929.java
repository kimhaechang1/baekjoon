import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1929 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        boolean [] isPrime = new boolean[n+1];
        // false = 소수, true = 소수가 아님
        isPrime[1] = true;
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(!isPrime[i]){
                for(int k = i+i ;k<=n;k=k+i){
                    isPrime[k] = true;
                }
            }
        }
        for(int i = m;i<=n;i++){
            if(!isPrime[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
