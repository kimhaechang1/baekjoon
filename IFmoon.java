// baekjoon
import java.io.*;
import java.util.StringTokenizer;

public class IFmoon {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String b = br.readLine();
            StringTokenizer stk = new StringTokenizer(b);
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            if(A < B){
                bw.write("<<");
                bw.flush();
            }
            else if(A>B){
                bw.write(">>");
                bw.flush();
            }
            else if(A==B){
                bw.write("==");
                bw.flush();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
