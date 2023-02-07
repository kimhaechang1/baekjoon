import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164 {
    // 문제 분석하기
    /*
    * 시간제한이 2초로 2억번의 연산안에 해결해야 한다.
    * N의 범위가 50만이므로 O(N)의 연산안안에 해결한다.
    * 현재 카드 번호가 1~N인데 카드의 가장 위에 있는 카드를 가장 아래로 옮겨야 한다는 말
    * 즉, 큐를 사용해야 함을 뜻한다.
    */

    // 손으로 풀어보기
    /*
    * N의 크기가 6이고 큐에 1 2 3 4 5 6 순서로 들어갔다고 하면
    * 첫 번째 반복문에 의해 1이 poll 되고 다시한번 더 poll 하면 2가 나오는데 이 때 2를 add로 가장뒤에 추가한다.
    * #1 결과값 : 3 4 5 6 2
    * 두 번째 반복문에 의해 3이 poll 되고 다시한번 더 poll 하면 4가 나오는데 이 때 4를 add로 가장뒤에 추가한다.
    * #2 결과값 : 5 6 2 4
    * 세 번째 반복문에 의해 5가 poll 되고 다시한번 더 poll 하면 6이 나오는데 이 때 6을 add로 가장뒤에 추가한다.
    * #3 결과값 : 2 4 6
    * 네 번째 반복문에 의해 2가 poll 되고 다시한번 더 poll 하면 4가 나오는데 이 때 4를 add로 가장뒤에 추가한다.
    * #4 결과값 : 6 4
    * 다섯 번째 반복문에 의해 6이 poll 되는데 이 때 큐의 길이가 1이므로 4를 리턴시키고 종료한다.
    */

    // 슈도 코드
    /*
    * int N : 카드의 최대숫자 지정
    * Queue<Integer> q : 카드를 담을 큐 선언
    * for(i : 1~N) {
    *   큐에 1~N까지의 카드 담기
    * }
    * while(큐의 길이가 1이 될때까지){
    *   poll 한번 수행
    *   add(q.poll()) : 그다음 poll한값을 뒤에 추가
    * }
    * 큐에 하나남은 값을 q.poll()한 값 출력*/

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(bf.readLine());

        for(int i = 1;i<=N;i++){
            q.add(i);
        }

        while(q.size()!=1){
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}
