import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IFmoon2 {
    public static void main (String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        if(score>=90&&score<=100) {
            bw.write("A");
            bw.flush();
        }
        else if(score>=80&&score<=89) {
            bw.write("B");
            bw.flush();
        }
        else if(score>=70&&score<=79) {
            bw.write("C");
            bw.flush();
        }
        else if(score>=60&&score<=69) {
            bw.write("D");
            bw.flush();
        }
        else bw.write("F");
        bw.flush();
        bw.close();
        br.close();
    }
}
