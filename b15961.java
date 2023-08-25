import java.util.*;
import java.io.*;

public class b15961 {
    static StringTokenizer stk;
    static int N;
    static int d;
    static int k;
    static int c;
    static int [] arr;
    public static void main(String[] args) throws Exception{
        /*
        N이 매우크므로 거의 한번 반복문안에 해결해야 한다.
        4개를 미리 집고서 최대값을 한번 갱신해주고
        그리고나서 첫번째로 집은걸 빼고 오른쪽 첨자를 다음으로 옮기면서 k개를 유지한채로 카운팅한다.
        이때 중복되는 숫자를 빼주었다면 전체 가짓수에는 변화가 없다는것을 주의하고
        오른쪽으로 하나 더 집을때 처음 집는것이라면 1개를 더 추가해야한다.
        추가) 추가적인 스시를 뽑는과정에서 1부터N까지로 했다가 99%에서 틀렸다.
        0부터 하니까 맞았다.
        */
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        for(int i= 0;i<N;i++){
            arr[i]= Integer.parseInt(bf.readLine());
        }

        int [] cnt = new int[d+1];
        int cc = 0;
        int max = 0;
        // 미리 0번부터 k개를 집는다.
        for(int i= 0;i<k;i++){
            if(++cnt[arr[i]] == 1){
                cc++;
            }
        }
        max = cc;
        for(int i= 0;i<N;i++){

            // 처음집은 스시를 놓는다.
            // 근데 왼쪽을 줄였고 오른쪽으로 갔더라도 가짓수의 개수에 변동이 없는 경우가 있다.
            if(--cnt[arr[i]] == 0 ) cc--;


            // 오른쪽에 스시접시를 집는다.
            // 이 때 오른쪽 스시접시가 한번도 집은적없다면 전체 가짓수에서 더해준다.
            // 또한 8개일때 인덱스 8을 넘어가게 된다면 0부터 다시 셈해야 하므로 %n만큼 해준다.
            if(++cnt[arr[(i+k)%N]] == 1) cc++;

            if(max <= cc){
                if(cnt[c] != 0 ) max = cc;
                else max = cc+1;
            }
        }
        System.out.println(max);
    }
}
