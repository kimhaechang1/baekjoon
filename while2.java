//this is can't execute in intellj
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class while2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nums;
        StringTokenizer stk;
        while((nums=br.readLine())!=null){
            stk = new StringTokenizer(nums);
            int A=Integer.parseInt(stk.nextToken());
            int B=Integer.parseInt(stk.nextToken());
            bw.write((A+B)+"\n");
        }
        br.close();
        bw.close();
    }
}

