import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11328 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bf.readLine());
        String [] buffer;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
             String answer = "Possible";
             int [] count = new int[26];

             buffer= bf.readLine().split(" ");
             for(char ch : buffer[0].toCharArray()){
                 count[ch-97]++;
             }
             for(char ch : buffer[1].toCharArray()){
                count[ch-97]--;
             }
             for(int k : count){
                 if(k!=0){
                     answer = "Impossible";
                     break;
                 }
             }
             sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
