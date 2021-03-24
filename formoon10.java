import java.io.BufferedReader;
import java.io.InputStreamReader;

public class formoon10 {
    public static void main(String[] args) throws Exception{
        int i;
        int k;
        int j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(i=N;i>=1;i--){
            for(k=1;k<i;k++){
                System.out.print(" ");
            }
            for(j=N;j>=k;j--){
                System.out.print('*');
            }
            System.out.println();
        }
        br.close();
    }
}
