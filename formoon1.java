// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class formoon1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a =Integer.parseInt(br.readLine());
        for(int i=1;i<10;i++){
            System.out.println(a+" * "+i+" = "+a*i);
        }
    }
}
