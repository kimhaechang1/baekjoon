import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class b1271 {
    static BigInteger n;
    static BigInteger m;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = new BigInteger(stk.nextToken());
        m = new BigInteger(stk.nextToken());
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
