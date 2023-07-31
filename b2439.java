import java.util.*;
import java.io.*;
public class b2439 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = n;i>0;i--){
            for(int j = 1;j<i;j++){
                sb.append(" ");
            }
            for(int j = i;j<=n;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
