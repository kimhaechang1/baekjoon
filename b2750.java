import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2750 {
    // 문제 분석하기
    /*
    * 시간제한이 2초이므로 2억번의 연산 내외로 해결해야한다.
    * 수의 개수가 천개고 범위가 -천 ~ +천까지의 정수이다.
    * 수의 범위는 매우 적기 때문에 n^2의 알고리즘으로도 해결가능하지만
    * 버블정렬을 연습 할 겸 버블정렬로 해결한다.
    */

    // 손으로 풀어보기
    /*
    * N = 5고 숫자가 5 2 3 4 1로 주어졌을 경우
    * 버블정렬 1페이즈
    * 5와 2를 비교 -> 5가 더큼 -> 스왑 -> 2 5 3 4 1
    * 5와 3을 비교 -> 5가 더큼 -> 스왑 -> 2 3 5 4 1
    * 5와 4를 비교 -> 5가 더큼 -> 스왑 -> 2 3 4 5 1
    * 5와 1을 비교 -> 5가 더큼 -> 스왑 -> 2 3 4 1 5
    * 5의 위치 선정완료, 인덱스기준 0~3번까지 위의 행동을 반복
    */

    // 슈도 코드
    /*
    * int N : 정렬해야할 수의 개수
    * int [] num : 정렬해야할 수를 담을 크기 N의 배열
    * for(i : N~1){
    *   for(k : 0~N){
    *       if(num[k]<num[k+1]){
    *           swap(num[k], num[k+1])
    *       }
    *   }
    * }*/


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] num = new int[N];
        for(int i= 0 ;i< N;i++){
            num[i] = Integer.parseInt(bf.readLine());
        }
        for(int i = N-1 ; i>-1;i--){
            for(int k = 0;k<i;k++){
                if(num[k]>num[k+1]){
                    int temp = num[k+1];
                    num[k+1] = num[k];
                    num[k] = temp;
                }
            }
        }
        for(int k : num) System.out.println(k);
    }
}
