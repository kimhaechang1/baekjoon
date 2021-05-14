// baekjoon
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IFmoon4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        if(X>0&&Y>0){
            bw.write(1+"");
        }
        else if(X<0&&Y>0){
            bw.write(2+"");
        }else if(X<0&&Y<0){
            bw.write(3+"");
        }else if(X>0&&Y<0){
            bw.write(4+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

