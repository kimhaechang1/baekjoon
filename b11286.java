import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b11286 {
    // 문제 분석하기
    /*
    * 시간제한이 2초로 2억번의 연산안에 해결해야한다.
    * 힙 성질을 사용해야 하고 연산해야할 수의 개수가 10만개 까지 주어지므로
    * N^2의 시간복잡도를 가진 알고리즘으로 해결할 수 없다.
    * 대신 nlogn의 시간복잡도를 가진 알고리즘으로 해결이 가능하다.
    * 주어진 숫자가 0이 아닐경우 : 배열에 0을 넣는다.
    * 0일 경우 : 현재 배열에서 절대값이 가장 작은 숫자를 빼낸다, 절대값이 같은경우 더 작은숫자 즉 음수를 빼낸다.
    * 배열이 비어있을 경우 0을 출력한다.
    * 위의 조건을 따졌을때 0이 주어지면 원하는 조건으로 정렬이 된 숫자를 빼내야한다.
    * 즉, 우선순위큐를 사용하면 원하는 정렬조건을 넣을 수 있다.
    */

    // 손으로 풀어보기
    /*
    * 처음 1이 주어지면 0이 아니므로 우선순위 큐에 add
    * 다음 -1은 0이 아니므로 우선순위 큐에 add
    * 다음은 0이므로 값 하나를 poll 해야 하는데 현재 큐에 1, -1이 있고 둘의 절댓값이 같으므로 음수인 -1을 출력한다.
    * 0을 한번 더 실행하면 비교할 대상 없이 1을 출력, 마지막 0에 대해서는 큐에 남아있는 원소가 없기 때문에 0을 출력한다.
    * */

    // 슈도코드 작성
    /*
    * int N : 연산할 숫자 개수
    * StringBuilder sb : 출력할 String 모아두는 곳
    * PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)=>{
    *   if(두개의 절대값이 같으면){
    *       return o1 > o2 ?  1 : -1;
    *   }else{
    *       return Math.abs(o1) > Math.abs(o2) ? 1 : -1;
    *   }
    * }); : 우선순위 큐 설정
    * for(i : 0~N){
    *   int query = 숫자 하나 입력받기
    *   if(query == 0){
    *       if(pq.size() == 0) 0을 스트링빌더에 넣기
    *       else pq.poll() 한 값을 스트링 빌더에 넣기
    *   }else{
    *       pq.add(query) 그대로 숫자 우선순위 큐에 넣기
    *   }
    * }*/
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
           if(Math.abs(o1) == Math.abs(o2)){
               return o1 - o2;
           }else{
               return Math.abs(o1) - Math.abs(o2);
           }
        });
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if( Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }else{
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0;i<N;i++){
            int query = Integer.parseInt(bf.readLine());
            if(query == 0){
                if(pq1.size() == 0) sb.append(0).append("\n");
                else sb.append(pq1.poll()).append("\n");
            }else{
                pq1.add(query);
            }
        }
        System.out.println(sb);
    }
}
