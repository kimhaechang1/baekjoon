import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b6198 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> bs = new Stack<>();
        int [] b = new int[n+1];
        for(int i= 1;i<=n;i++){
            b[i] = Integer.parseInt(bf.readLine());
        }
        long count=0;
        /* peek : 10 > 3 -> 10 count : + stack.size() = 1, push(3)
        *  peek : 3 < 7 -> stack.pop() -> peek > 7 -> 10 count : + stack.size() = 2 7
        *  peek : 7 > 4 -> 10 7 count : + stack.size() = 4, push(4)
        *  peek : 4 < 12 -> 10 7 < 12 -> 10 < 12 -> empty 로 인해 12, count : 4
        *  peek : 12 > 2 -> 12 2 count 5
        * 빌딩의 개수가 8만개 이고 내림차순으로 정렬되어있는 경우
        * 약 640억의 숫자가 나온다. -> 이는 int 범위를 초과한다.
        * 답의 범위가 큰 수가 나올수있는지 항상 생각해보자.
        * */

        for(int i= 1;i<=n;i++){
            if(bs.isEmpty()){
                bs.push(b[i]);
            }else{
                while(true) {
                    if(bs.isEmpty()){
                        bs.push(b[i]);
                        break;
                    }
                    if (bs.peek() > b[i]) {
                        count+= bs.size();
                        bs.push(b[i]);
                        break;
                    } else {
                        bs.pop();
                    }
                }
            }
        }
        System.out.println(count);

    }
}
