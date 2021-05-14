// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class formoon6 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine()) ;
        int i=0;
        for(i=S;i>0;i--){
            System.out.println(i);
        }
    }
}
