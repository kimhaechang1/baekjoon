import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b5597 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean []stuN = new boolean[31];
        int count = 0;
        for(int i = 1 ;i< 29;i++){
            stuN[Integer.parseInt(bf.readLine())] = true;
        }
        for(int i = 1 ;i<31;i++){
            if(!stuN[i]){
                System.out.println(i);
            }
        }
    }
}
