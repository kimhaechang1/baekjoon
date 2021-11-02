import java.io.BufferedReader;
import java.io.InputStreamReader;

public class steps {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(bf.readLine());
        int end = Integer.parseInt(bf.readLine());
        int gap = end-start;
        int step=1;
        if((int)Math.sqrt(gap)==Math.sqrt(gap)){
            step = 2*(int)Math.sqrt(gap)-1;
        }else if(gap<=(int)Math.sqrt(gap)*(int)Math.sqrt(gap)+(int)Math.sqrt(gap)){
            step = 2*(int)Math.sqrt(gap);
        }else {
            step = 2 * (int) Math.sqrt(gap) + 1;
        }
        System.out.println(step);
    }
}
