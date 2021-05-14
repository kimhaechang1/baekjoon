// baekjoon
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class formoon7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int []A = new int[T+1];
        int []B = new int[T+1];
        for(int i=1;i<=T;i++){
            String nums = br.readLine();
            StringTokenizer stk = new StringTokenizer(nums);
            A[i]=Integer.parseInt(stk.nextToken());
            B[i]=Integer.parseInt(stk.nextToken());
            bw.write("Case #"+i+": "+(A[i]+B[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
