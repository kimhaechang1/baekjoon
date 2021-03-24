import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class formoon2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        String [] line = new String[T];
        int []A = new int[T];
        int []B = new int[T];
        for(int i=0;i<T;i++){
           line[i] = br.readLine();
           stk = new StringTokenizer(line[i]);
           A[i]= Integer.parseInt(stk.nextToken());
           B[i]= Integer.parseInt(stk.nextToken());
        }
        for(int i=0;i<T;i++){
            System.out.println(A[i]+B[i]);
        }

    }
}
