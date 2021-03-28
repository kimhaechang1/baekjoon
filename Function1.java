import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Function1 {
        long sum(int[] a ){
            long ans=0;
            for(int i:a){
                ans+=i;
            }
            return ans;
        }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function1 t = new Function1();
        int i=0;
        int k=0;
        int [] b = new int[3000000];
        String n;
        while((n=br.readLine())!=null){
            i = Integer.parseInt(n);
            b[k]=i;
            k++;
        }
        /*String n = br.readLine();
        StringTokenizer stk = new StringTokenizer(n);
        while(stk.hasMoreTokens()){
            b[i] = Integer.parseInt(stk.nextToken());
            i++;
        }*/
        System.out.println(t.sum(b));
    }
}
