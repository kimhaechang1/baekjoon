import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1919 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] buffer = new String[2];
        for(int i= 0;i<buffer.length;i++){
            buffer[i] = bf.readLine();
        }
        int [] count1 = new int[26];
        int [] count2 = new int[26];
        for(char ch : buffer[0].toCharArray()){
            count1[ch-97]++;
        }
        for(char ch : buffer[1].toCharArray()){
            count2[ch-97]++;
        }

        int len =0;
        for(int k=0;k<count1.length;k++){
            int abs = Math.abs(count1[k] - count2[k]);
            if(abs > 0) len+= abs;
        }
        System.out.println(len);
    }

}
