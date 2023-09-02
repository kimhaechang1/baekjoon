import java.util.*;
import java.io.*;

public class b1654 {
    static int K;
    static int N;
    static long []arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        // K개의 랜선들을 우에 짤라서 N개로 만들어야함
        // 이렇게 만드는 데 있어서 똑같은 길이의 랜선으로 N개를 만드는데 있어서 최대값
        // 기준 센치가 더 작으면 작을수록 더 많은 개수를 만들 수 있긴하다.
        // N개 보다 많이 만드는경우도 N개를 만드는것에 포함된다.
        // 기준 cm의 최소값은 1이고, 최대값은 모든랜선을 사용해서 N개를만드는 것으로
        // 1~(K개의 랜선 길이의 합 / N) 만큼의 범위에서 주어진 조건을 만족하는 최대 길이를 찾아야 한다.
        // upper_bound binarysearch를 통해 만들 수 있는 랜선의 개수가 처음으로 변화하는 순간을 찾고
        // 그 순간의 이전 인덱스가 가리키는것이 최대 길이가 될듯?
        // 즉 N개보다 더 많아지는 순간은 상관이없는데, N개보다 처음으로 적어지는순간
        // 결국 랜선의 길이가 더 큰 영역에있어서 find값을 넘어서는 인덱스를 찾아야하므로 upperbound가 된다.
        arr= new long[K];
        long sum = 0;
        for(int i= 0;i<K;i++){
            arr[i] = Integer.parseInt(bf.readLine());
            sum+=arr[i];
        }

        if(N == 1){
            Arrays.sort(arr);
            System.out.println(arr[K-1]);
        }else {
            long start = 1;
            long end = sum;
            long result = 0;
            while (start < end) {
                long mid = (start + end) / 2;
                result = 0;
                for (int i = 0; i < K; i++) {
                    result += (arr[i] / mid);
                }
                if (result < N) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(end - 1);
        }
    }
}
