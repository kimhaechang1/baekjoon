import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1850 {
    static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);

    }
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        long count = gcd(a,b);
        for(int i = 0;i<count;i++){
            sb.append("1");
        }
        System.out.println(sb);
    }
}
