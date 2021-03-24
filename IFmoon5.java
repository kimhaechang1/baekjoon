import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IFmoon5 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String HM = br.readLine();
        StringTokenizer stk = new StringTokenizer(HM);
        int H = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
            if(M>=45){
                bw.write(H+" "+(M-45)+"\n");
                bw.flush();
            }
            else if(M<=45&&H==0) {
                bw.write(23 +" "+(M-45+60) + "\n");
                bw.flush();
            }
            else if(M<=45&&H<24){
                bw.write((H-1)+" "+(M-45+60)+"\n");
                bw.flush();

        }

    }
}
