import java.io.*;
import java.util.*;
public class b2609 {
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");
        int a = 0;
        int b = 0;
        if(Integer.parseInt(temp[0]) > Integer.parseInt(temp[1])){
            a= Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
        }else {
            a = Integer.parseInt(temp[1]);
            b = Integer.parseInt(temp[0]);
        }
        int result = gcd(a,b);
        System.out.println(result+"\n"+((a*b)/result));
    }
}
