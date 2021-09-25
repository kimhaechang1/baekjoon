// 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IFmoon3 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if(year%4==0&&(year%100!=0||year%400==0)){
            bw.write(1+"");
            bw.flush();
        }else{
            bw.write(0+"");
            bw.flush();
        }
        bw.close();
        br.close();

    }
}
