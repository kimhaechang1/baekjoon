// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class function3 {
    public static int hannum(int n){
        int c=0;
        if(n<100){
            return n;
        }else{
            for(int i=100;i<=n;i++){
                if(((i/100)-((i%100)/10))==(((i%100)/10)-(i%10))){
                    c++;
                }
            }
        }
        return 99+c;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = hannum(N);
        System.out.println(count);
    }
}
