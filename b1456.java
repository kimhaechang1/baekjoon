import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1456 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        boolean [] isPrime = new boolean[10000001];
        isPrime[0] = isPrime[1] = true;
        for(int i = 2;i<((int)Math.sqrt(10000001))+1;i++){
            if(!isPrime[i]){
                for(int k = i+i;k<10000001;k = i+k){
                    isPrime[k] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2;i<isPrime.length;i++){
            if(!isPrime[i]){
                long num = i;
                while((double)i <= (double)b/(double)num) {
                    if ((double) i >= (double) a / (double) num) {
                        count++;
                    }
                    num *= i;
                }
            }
        }
        System.out.println(count);
    }
}
