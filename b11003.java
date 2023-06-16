import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b11003 {
    static String [] buffer;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        buffer = bf.readLine().split(" ");
        int len = Integer.parseInt(buffer[0]);
        int l = Integer.parseInt(buffer[1]);
        buffer = bf.readLine().split(" ");
        ArrayDeque<Node> deque = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<len;i++){
            int now = Integer.parseInt(buffer[i]);
            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.pollLast();
            }
            deque.addLast(new Node(i, now));
            if(deque.getFirst().index <= i-l){
                deque.pollFirst();
            }
            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }

}
class Node{
    int value;
    int index;
    public Node( int index, int value){
        this.index = index;
        this.value = value;
    }
}

// 데크를 이용한 슬라이딩 윈도우 기법으로 문제를 풀 수 있음
// 처음에 Ai에서 i가 0보다 작은 즉 i-l<0인 값들은 무시한다 << 여기가 중요한 지점
// 그리고 최솟값 만을 지속적으로 뽑아야하므로 최 앞단 값을 최소로 둘것이라고 결정내렸다면
// 뒤에오는 후보 값들은 무조건 가장 최소로 모여있어야한다.
// 그리고 윈도우를 슬라이딩 하는 조건은 맨 앞단 원소의 시작 인덱스가 이제 필요없게 되었을 때
// 즉, 위의 코드 기준으로는 i = 0부터 시작하므로 원래 문제의 조건에서 -1 한 조건식을 기준으로 하게 된다.
// (문제 : i<=0, i = 1부터, 위 코드 조건 : i<=-1, i = 0부터)
// 위 문제에서 첫 예제에 대한 슬라이딩 크기는 3이고
// 그래서 슬라이딩의 크기를 초과하는 탐색 할 인덱스가 3일때 처음 맨앞단을 제거하게 된다.
// 즉, 현재 반복문의 인덱스가 i-l의 인덱스에 도달했을때
// 낡은 앞단 원소를 제거하면 된다.

