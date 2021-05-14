// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class while3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A =N;
        int count=0;
        while(true){
            N = ((N%10)*10)+(((N/10)+(N%10))%10);
            count++;
            if(N==A){
                System.out.println(count);
                break;
            }
        }
    }
}

