import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1931 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [][] time = new int[n][2];
        int count  = 0;
        int endTime = -1;
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            time[i][0] = Integer.parseInt(stk.nextToken());
            time[i][1] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(time, ((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));
        for(int i = 0;i<n;i++){
            if(time[i][0]>=endTime){
                count++;
                endTime = time[i][1];
            }
        }
        System.out.println(count);
    }
}
