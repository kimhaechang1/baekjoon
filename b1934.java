import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1934 {
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);

    }
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append((a*b)/gcd(a,b)).append("\n");
        }
        System.out.println(sb);
    }
}
