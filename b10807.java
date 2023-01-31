import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10807 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int answer = 0;
        String np = bf.readLine();
        int foundNum = Integer.parseInt(bf.readLine());
        for(String s : np.split(" ")){
            if(foundNum == Integer.parseInt(s)){
                answer+=1;
            }
        }
        System.out.println(answer);
    }
}
