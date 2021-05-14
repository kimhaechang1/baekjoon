// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class formoon11 {
    public static void main(String[] args) throws Exception{
        StringTokenizer stk;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String NX = br.readLine();
         stk = new StringTokenizer(NX);
         int N = Integer.parseInt(stk.nextToken());
         int X = Integer.parseInt(stk.nextToken());
         int []A = new int[N];
         String line = br.readLine();
         stk = new StringTokenizer(line);
         for(int i=0;i<N;i++){
             A[i]=Integer.parseInt(stk.nextToken());
             if(A[i]<X){
                 System.out.print(A[i]+" ");
             }
         }

    }
}
