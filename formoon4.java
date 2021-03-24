import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class formoon4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        int []A = new int[T];
        int []B = new int[T];
        for(int i=0;i<T;i++){
            String line = br.readLine();
            stk = new StringTokenizer(line);
            A[i]=Integer.parseInt(stk.nextToken());
            B[i]=Integer.parseInt(stk.nextToken());
            bw.write(A[i]+B[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
