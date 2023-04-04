import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17298 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        /*
        * 0 1 2 3
        * 3 5 2 7
        * 5 7 7 -1
        *
        * 무조건 자기 자신보다 오른쪽에 있는 숫자들 중에서
        * 크면서 가장 가까이 있는 수가 오큰수로 당첨된다.
        * 즉 해당 인덱스의 오큰수로 당첨된다는 의미
        * 원소별로 오른쪽만 처다보면 되고
        * stack을 사용한다.
        * 우선 앞에서부터 시작한다고 생각하면
        * 반복문으로 0번 수열부터 시작하면서
        * 스택이 비어있으므로 인덱스를 넣는다.
        * 스택이 비어있지 않으므로 peek값을 꺼내어 본다.
        * peek값에 해당하는 원소보다 입력받은 원소가 더 크므로 [peek]:3 < [1]:5
        * 스택에서 인덱스를 pop하고 오큰수 배열에 해당 인덱스에 입력받은 원소를 저장한다.
        * 그리고 입력받은 원소의 인덱스를 push한다.
        * 현재 스택에 1번이 들어가고, 다음 원소를 입력받으면 [2]:2로서
        * 스택에 원소가 남아있고 peek값을 꺼내어 실제배열에서 무슨값인지 알아보면
        * [peek] : 5 > [2]:2 이므로 스택에 넣는다.
        * 그 다음원소로서 [3]:7 이고 이는 [peek]:2 < [3]:7 이므로
        * 스택에 원소들을 빼내면서 오큰수 배열에 해당하는 인덱스에 입력받은 원소값 7을 넣는다.
        * 그리고 스택에 입력받은 원소의 인덱스를 push한다.
        * 수열을 전부 돌고 나면 무조건 마지막원소는 오큰수가 존재할수 없다.
        * 따라서 스택에 남아있는 마지막원소의 인덱스 번호를 꺼내어서
        * 오큰수배열에 해당하는 인덱스에 -1을 넣고 종료
        * */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] a = new int[n];
        Stack<Integer> s = new Stack<>();
        stk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int [] ans = new int[n];
        for(int i= 0;i<n;i++){
            a[i]= Integer.parseInt(stk.nextToken());
        }
        for(int i = 0;i<n;i++){
            if(s.isEmpty()){
                s.push(i);
            }else{
                while(!s.isEmpty() && a[s.peek()]<a[i]){
                    ans[s.pop()] = a[i];
                }
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            ans[s.pop()] = -1;
        }
        for(int k : ans) sb.append(k).append(" ");
        System.out.println(sb);
    }
}
