// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class array6 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String [] line = new String[T];
        int s;
        int sum;
        int []score;
        for(int i=0;i<T;i++){
            line[i]=br.readLine();
        }
        for(int i=0;i<T;i++){
            sum=0;
            s=0;
            char []ch = line[i].toCharArray();
            score = new int[ch.length];
            for(int k=0;k<ch.length;k++){
                if(ch[k]=='O'){
                    ++s;
                    score[k] = s;
                }
                else if(ch[k]=='X'){
                    s=0;
                    score[k]= s;
                }
            }
            for(int j: score){
                sum+=j;
            }
            System.out.println(sum);
        }
    }
}
