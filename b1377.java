import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1377 {
    // 문제 분석하기
    /*
    * 시간제한이 2초이므로 2억번의 연산내외로 해결해야한다.
    * 수의 개수가 50만개 이므로 일반적인 버블정렬로 해결하면
    * 시간초과가 난다.
    * 버블정렬의 주요 특징은 숫자하나가 오른쪽으로 여러번 이동할 수는 있지만
    * 왼쪽으로는 한 페이즈당 한 번 이동한다.
    * 그말은 즉슨 왼쪽으로 가장 많이 이동한 횟수가
    * 결국 정렬이 실질적으로 종료되는 페이즈 종료시점이 된다.
    * 왜냐하면 왼쪽으로 가장 많이 이동한 횟수는 즉, 그 동안에 나머지 숫자들의 위치가
    * 결정이 나 있기 때문이다.
    * 마지막으로 이 문제의 C++ 코드를 보면 정렬이 실질적으로 완료되었음에도
    * 한번 더 검사를 진행하므로, 가장많이 이동한 횟수 +1이 정답이 된다.
    * 문제를 이 방식으로 해결함에 있어서
    * Comparable 인터페이스를 implements하는 데이터를 받을 클래스를 하나 만들고
    * 그 클래스에 index 필드와 data 필드에 값을 넣고
    * compareTo를 통해 data값을 기준으로 정렬을 진행한다.
    * 이렇게 클래스화 시키는게 편한 이유는 정렬 하기 전 인덱스 번호와 정렬 한 후 인덱스번호를 비교하기 위해서이다.
    * 0  1 2 3 4
    * 10 1 5 2 3
    * 1  2 3 5 10
    */

    //손으로 풀어보기
    /*
     * 0  1 2 3 4
     * 10 1 5 2 3
     * 1  2 3 5 10
     * 에서 두 인덱스의 차이를 구해보면
     * 10 : -4
     * 1 : +1
     * 5 : -1
     * 2 : +2
     * 3 : +2
     * 따라서 이동한 횟수의 최대값은 2인데
     * 여기서 마지막에 정렬을 완료했음에도 검사하는 횟수까지 포함하여 3이 정답이 된다.
     */

    // 슈도코드 작성
    /*
    * 메인클래스 {
    * int N : 숫자의 개수 입력받기
    * int []num : 숫자들을 입력받을 크기N의 배열
    * Arr [] a = new Arr[N]; 값을 기준으로 정렬할 객체배열
    * for(int i : 0~N){
    *   a = new Arr(i, 입력받은 숫자);
    * }
     4 : (0,10)
     3 : (2, 5)
     2 : (4, 3)
     1 : (3, 2)
     0 : (1, 1)
    * Arrays.sort(a)
    * for(int i : 0~N){
    *       정렬하기 전 인덱스 - 정렬 한 후 인덱스
    *   }
    * }
    * class Arr implements Comparable{
    *   int index : 인덱스 역할
    *   int value : 값 역할
    *
    *   public Arr (int index, int value){
    *       super();
    *       this.index = index;
    *       this.value = value;
    *   }
    *
    *   compareTo 메서드 구현하기
    *
    * }*/


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Arr [] a = new Arr[N];
        for(int i = 0 ;i<N;i++){
            a[i] = new Arr(i, Integer.parseInt(bf.readLine()));
        }
        Arrays.sort(a);
        int max = 0;
        for(int i = 0;i<N;i++){
            int cha = a[i].index - i;
            if(max < cha) max = cha;
        }

        System.out.println(max+1);
    }

}
class Arr implements Comparable<Arr>{
    public int value;
    public int index;

    public Arr(int index, int value){
        super();
        this.value = value;
        this.index = index;
    }

    public int compareTo(Arr o1){
        return this.value - o1.value;
    }
}
