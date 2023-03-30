import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1016 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        long min = Long.parseLong(stk.nextToken());
        long max = Long.parseLong(stk.nextToken());
        boolean [] isJegobnono = new boolean[(int)(max-min+1)];
        int count = 0;
        for(long i = 2;i*i<=max;i++){
            long powerNum = i*i;
            long start = min%powerNum == 0 ? min/powerNum : (min/powerNum)+1;
            for(long k = start ; k*powerNum<=max;k++){
                isJegobnono[(int)((k*powerNum)-min)] = true;
            }
        }
        for(int i = 0;i<max-min+1;i++){
            if(!isJegobnono[i]){
                count++;
            }
        }
        System.out.println(count);

    }
}
