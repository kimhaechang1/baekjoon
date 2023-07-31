import java.util.*;
import java.io.*;
public class b2443 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i= n;i>=1;i--){

            for(int j = i;j<n;j++){
                sb.append(" ");
            }
            for(int k = 0;k<2*i-1;k++){
                sb.append("*");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
