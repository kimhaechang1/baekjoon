import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class while1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String nums = br.readLine();
            StringTokenizer stk = new StringTokenizer(nums);
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            if(A+B==0){
                break;
            }
            bw.write((A+B)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
