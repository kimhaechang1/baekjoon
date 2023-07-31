import java.util.*;
import java.io.*;
public class b2440 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
