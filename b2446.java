import java.io.*;
import java.util.*;
public class b2446 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<i;j++){
                sb.append(" ");
            }
            for(int k = 2*(n+1-i)-1;k>0;k--){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = n-1;i>=1;i--){
            for(int j = i;j>1;j--){
                sb.append(" ");
            }
            for(int k = 0;k<2*(n-i+1)-1;k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
