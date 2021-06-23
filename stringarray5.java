import java.io.*;
import java.util.*;
public class stringarray5 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer stk = new StringTokenizer(s);
        System.out.println(stk.countTokens());
    }
}
