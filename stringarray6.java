import java.io.*;
import java.util.*;
public class stringarray6 {
    public static void main(String[] args) throws Exception{
        // solution 1 : StringBuilder.reverse() 사용
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char [] num1;
        char [] num2;
        char tmp;
        StringTokenizer stk = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int a = Integer.parseInt(sb.append(stk.nextToken()).reverse().toString());
        int b = Integer.parseInt(sb2.append(stk.nextToken()).reverse().toString());

        // solution 2 : 문자 단위 swap
        /*int a, b;
        num1 = stk.nextToken().toCharArray();
        num2 = stk.nextToken().toCharArray();
        tmp = num1[0];
        num1[0]=num1[2];
        num1[2]=tmp;
        sb.append(num1[0]).append(num1[1]).append(num1[2]);
        tmp = num2[0];
        num2[0]=num2[2];
        num2[2]=tmp;
        sb2.append(num2[0]).append(num2[1]).append(num2[2]);
        a = Integer.parseInt(sb.toString());
        b= Integer.parseInt(sb2.toString());
        if(a>b) System.out.println(a);
        else System.out.println(b);*/
    }
}
