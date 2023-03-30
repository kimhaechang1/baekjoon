import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] exp = (bf.readLine()).split("-");
        int [] num = new int[exp.length];
        for(int i = 0;i<exp.length;i++){
            int n = 0;
            if(exp[i].contains("+")){
                for(String k : exp[i].split("\\+")){
                    n += Integer.parseInt(k);
                }
            }else{
                n = Integer.parseInt(exp[i]);
            }
            num[i] = n;

        }
        int init = num[0];
        if(num.length == 1){
            System.out.println(init);
        }else{
            for(int i = 1;i<num.length;i++){
                init -=num[i];
            }
            System.out.println(init);
        }
    }
}
