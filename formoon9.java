// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class formoon9 {
    public static void main(String[] args) throws Exception{
        int i;
        int k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(i=1;i<=N;i++){
            for(k=1;k<=i;k++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
