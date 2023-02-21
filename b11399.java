import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11399 {
    /*
    * 문제 분석하기
    * 시간제한이 1초이므로 1억번의 연산내외로 해결해야한다.
    * 문제에서 그리디 방식을 사용하면
    * 결국 시간이 적게 드는사람부터 돈을 인출한다면 무조건 최소의 시간합을 가지게 된다.
    * 따라서 정렬을 선택해야 하는데 N의 크기가 1000이므로 N^2의 정렬을 사용해도 된다.
    * 많은 정렬중에서 선택정렬로 이 문제를 정렬 해 본다.
    * 정렬을 한 후 합배열을 구하여 합배열의 원소들을 전부 합한다.
    */
    /*
    * 손으로 풀어보기
    * 배열의 크기가 5고 원소가 3 1 4 3 2 로 주어졌을 때
    * 정렬된 배열의 크기를 1로 두고, 1을 삽입한다고 하면
    * 이미 정렬되 있는 원소와 비교했을 때 더 작으므로
    * 3을 오른쪽으로 하나 땡기고 1을 그 빈자리에 넣는다
    * -> 1 3 4 3 2
    * 정렬된 배열의 크기를 2로 두고, 4를 삽입한다고 하면
    * 현재 위치가 가장 어울리므로 바뀌는것 없이 둔다.
    * -> 1 3 4 3 2
    * 정렬된 배열의 크기를 3로 두고, 3을 삽입한다고 하면
    * 처음으로 3보다 작은 숫자인 1의 위치에서 +1 한 만큼의 위치에 삽입하고
    * 남은 원소들을 오른쪽으로 땡겨준다.
    * -> 1 3 3 4 2
    * 정렬된 배열의 크기를 4로 두고, 2를 삽입한다고 하면
    * 처음으로 2보다 작은 숫자인 1의 위치 +1 한 만큼의 위치에 삽입하고
    * 남은 원소들을 오른쪽으로 땡겨준다.
    * -> 1 2 3 3 4
    * 
    * 이렇게 정렬된 소요 시간들을 가지고 실제 각각의 걸리는 시간을 구하기 위해서
    * 합배열 S를 만든다.
    * -> 1 3 6 9 13
    * 
    * 실제 걸리는 시간들의 합을 구해야하므로
    * 전부 다 더한다
    * -> 32
    */
    /*
    * 슈도코드 작성
    * int n : 사람 수 
    * int []time  : 시간 배열
    * int []s : 합배열
    * for(int i : 1~n){
    *   int insertIndex : 삽입 할 원소 인덱스번호
    *   int insert : 삽입 할 원소 값
    *   for(int k : i-1~0){
    *       삽입 할 원소가 처음으로 커지는 순간 을 찾고
    *       k+1번째를 삽입 할 인덱스번호로 넣음
    *   }
    *   만약 정렬 할 원소가 1개뿐이라면 0번에 그대로 삽입 해 놓음
    *   for(int k : i~insertIndex){
    *       다른원소들을 오른쪽으로 한칸씩 밀어둠
    *   }
    *   time[insertIndex] = insert;
    * }
    * for(int i = 1;i<s.length;i++){
    *   합배열 구하고 누적하여 더하기
    * }
    * 누적된 값 출력*/

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int [] times = new int[n];
        int [] s = new int [n+1];
        for(int i = 0;i<n;i++){
            times[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i = 1;i<n;i++){
            int insertIndex = i;
            int insert = times[i];
            for(int k = i-1;k>-1;k--){
                if(times[k] < times[insertIndex]){
                    insertIndex = k+1;
                    break;
                }
                if(k == 0) insertIndex = 0;
            }
            for(int k = i;k>insertIndex;k--){
                times[k] = times[k-1];
            }
            times[insertIndex] = insert;
        }
        int sum = 0;
        s[0] = times[0];
        for(int i = 1;i<times.length;i++){
            s[i] = times[i] + s[i-1];
        }
        for(int k : s) sum+=k;
        System.out.println(sum);
    }
}
