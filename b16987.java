import java.util.*;
import java.io.*;
public class b16987 {
    static int N;
    static int [][] arr;
    static int M = 2;
    static StringTokenizer stk;
    static int max = 0;

    static void perm(int depth){

        if(depth == N){
            int count = 0;
            for(int i= 0;i<N;i++){
                if(arr[i][0] <= 0){
                    count++;
                }
            }
            if(max < count){
                max = count;
            }
            return;
        }
        boolean isCan = false;
        for(int i = 0;i<N;i++){
            if(i == depth){
                continue;
            }
            if(arr[i][0] > 0 && arr[depth][0] > 0){
                arr[depth][0] -= arr[i][1];
                arr[i][0] -= arr[depth][1];
                isCan = true;
                perm(depth+1);
                arr[depth][0] += arr[i][1];
                arr[i][0] += arr[depth][1];
            }
        }
        // 여기까지 왔다는 것은 다른 모든 계란이 깨졌거나 지금 잡고있는 계란이 이미 깨져있는 경우
        // 따라서 for문 밖에서 다음을 탐색하는 것
        if(!isCan){
            perm(depth+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][2];

        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            arr[i][0]= Integer.parseInt(stk.nextToken());
            arr[i][1]= Integer.parseInt(stk.nextToken());
        }
        max = 0;
        perm(0);
        System.out.print(max);
    }
}
