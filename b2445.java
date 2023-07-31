import java.io.*;
import java.util.*;
public class b2445 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(bf.readLine());
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                sb.append("*");
            }
            for(int k = 0; k<2*(n-i);k++){
                sb.append(" ");
            }
            for(int j = 1;j<=i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = n-1;i>=1;i--){
            for(int j = 1;j<=i;j++){
                sb.append("*");
            }
            for(int k =(2 * (n-i)) ;k>0;k--){
                sb.append(" ");
            }
            for(int j = 1;j<=i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
