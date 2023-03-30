import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1747 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        while(true){
            if(isPrime(n) && isPalin(n)){
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    private static boolean isPalin(int num) {
        char [] t = String.valueOf(num).toCharArray();
        int s = 0;
        int e = t.length -1;

        while(s < e){
            if(t[s] != t[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if(num == 1){
            return false;
        }
        for(int i = 2;i<((int)Math.sqrt(num))+1;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
