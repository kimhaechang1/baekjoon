import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10986 {
    // 이런문제가 나오면 차근차근 따라해보는 것도 좋다.
    // 핵심은
    // 합배열을 구하고, 그것들을 각각 m으로 나눈 나머지 계산해보면
    // 나머지가 있는것들이 있고 나머지가 없는 것 들이 있다.
    // 여기서 나머지가 같은 숫자끼리 서로 구간합을 빼주면
    // 그 사이구간은 무조건 나누어 떨어지게 되어있다.
    // 따라서 이미 연속된 숫자의 합배열이 나누어 떨어지는게 있는지 카운팅 하고
    // 잘려진 구간합이 나누어 떨어지는지는 나머지가 같은 것들중 2개를 뽑으면 된다.
    // 2개라는 특성 때문에 공식은 무조건 전체 N개로 뒀을 때
    // (N*(N-1)/2) 가 된다.
    // 구현부에서의 핵심은 숫자가 int범위를 벗어 날 수 있다는 점을 생각해야 하고
    // 구간합을 나누고 남은 숫자의 개수를 카운팅 할 배열이 필요하다는 점이다.
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int count = 0;
        long [] t = new long[n+1];
        long [] r = new long[n+1];
        long []pc = new long[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 1; i<n+1;i++){
            t[i] = Integer.parseInt(stk.nextToken());
            r[i] = r[i-1] + t[i];
            int namu = (int)r[i]%m;
            if(namu==0){
                count++;
            }
            pc[namu]++;
        }

        for(int i = 0;i<m;i++){
            if(pc[i]>1){
                count += (pc[i]*(pc[i]-1)/2);
            }
        }
        System.out.println(count);

    }
}
