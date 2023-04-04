import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1158 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        /*
        * 넣은 순서대로 했을 때 젤 처음 숫자를 빼내고
        * 뒤에 붙여주게 되면 중간 원소를 빼내고나서 다시 K번째 원소가 몇번째인지 계산하는데 쉬워진다. */
        Queue<Integer> queue = new LinkedList<>();
        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k= Integer.parseInt(stk.nextToken());
        for(int i = 1;i<=n;i++){
            queue.offer(i);
        }
        int count = 0;
        StringBuilder sb  = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()){
            int num = queue.poll();
            count++;
            if(count == k){
                sb.append(num);
                if(!queue.isEmpty()){
                    sb.append(", ");
                }else{
                    sb.append(">");
                }
                count = 0;
            }else{
                queue.offer(num);
            }
        }
        System.out.println(sb);
    }
}

/*[1 2 3 4 5 6 7]
*
* q.poll().offer()
* [2 3 4 5 6 7 1]
* q.poll().offer()
* [3 4 5 6 7 1 2]
* q.poll() -> 3, 6, 2, 7, 5
* [4 5 6 7 1 2]
* [7 1 2 4 5]
* [4 5 7 1]
* [1 4 5]
* [1 4]*/