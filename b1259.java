import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while(!(temp= bf.readLine()).equals("0")){
            char [] re = temp.toCharArray();
            boolean isPalin = true;
            for(int i = 0, j = temp.length()-1;i<temp.length()&& j>-1;i++,j--){
                if(re[i] != re[j]){
                    isPalin = false;
                    break;
                }
            }
            if (isPalin) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
