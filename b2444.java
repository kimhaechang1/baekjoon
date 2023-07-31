import java.util.*;
import java.io.*;
public class b2444 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i= 1;i<=n;i++){
            for(int j = i;j<n;j++){
                sb.append(" ");
            }
            for(int k = 0;k<2*i-1;k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = n-1;i>=1;i--) {
            for (int j = n - 1; j >= i; j--) {
                sb.append(" ");
            }
            for (int k = 2 * i - 1; k > 0; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
