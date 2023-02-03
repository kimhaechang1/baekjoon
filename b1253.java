import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1253 {
    // 문제 분석하기
    /*
    * 문제에서 서로 다른 두 수의 합으로 표현되는 수 인 '좋은수'의 개수를 물었으므로
    * 결국 서로 다른 두 수의 합이 '좋은수'가 되는 가짓수를 구해야한다.
    * 이것에서 투 포인터 알고리즘을 적용시킬 수 있다.
    * 시간제한이 2초이고 수의크기가 절댓값 10억이므로 -10억~+10억 범위 라는걸 알아야 한다.
    * 또한 문제에서 수의 위치가 다르면 값이 같아도 다른수 라는 점에서
    * 인덱스 번호가 틀리면 값이 같아도 다른수로 취급하게 된다.
    * 매 숫자마다 서로 다른수의 합으로 나타낼 수 있는지 검사해야하므로
    * 기본적으로 시간복잡도가 N이 곱해지게 된다.
    * 숫자의 개수가 2000개 이므로 매 숫자마다 좋은수인지 검사하는 알고리즘은 N^2보다 작아야한다.
    * 따라서 주어진 숫자를 정렬하고 투 포인터 알고리즘을 사용하면 nlogn의 알고리즘으로 좋은수를 찾을 수 있다.
    * */
    // 손으로 풀어보기
    /*
     * 문제에서 주어진 예시를 통해 풀어보면
     * 현재 N이 10으로 주어졌고 숫자들은 1 2 3 4 5 6 7 8 9 10으로 주어졌다.
     * 처음에 1을 생각해보면 서로 다른 두 수의 합으로 만들 수 없다.
     * 다음 2를 생각하면 마찬가지로 만들 수 없다.
     * 다음 3을 생각하면 1 과 2의 합으로 만들 수 있다.
     * 이런식으로 만들어 낼 수 있는데, 숫자의 범위가 음수를 허용한 정수이므로
     * 0 0 0 -1 1 일 때
     * 1을 만들기 위해서 서로다른 수를 선택해야 하는데 본인자신을 선택해서 첫번째 0과 본인자신을 더하여 좋은수로 선발해서는 안된다.
     * 결국 정렬된 데이터에서 좋은수 인지 찾을 숫자하나를 지목하고
     * 해당 숫자가 진짜 좋은수 인지 투포인터를 사용하여 검사한다.
     * 투포인터 조건 찾기
     * 시작포인터와 끝 포인터는 양쪽 끝에서 시작한다.
     * 종료조건은 양쪽 끝에서 시작하므로 시작포인터가 끝포인터를 재낄때 끝난다.
     * 시작포인터의 늘리는 조건은 두 포인터가 가리키는 합이 M보다 작을때 이고
     * 끝 포인터를 늘리는 조건은 두 포인터가 가리키는 합이 M보다 클때 이다.
     * 만약에 M과 같아진다면, 자기자신을 포함하고있는지 검사하고
     * 현재 시작지점이 포함하고있다면 시작지점을 늘려버리고
     * 끝지점이 포함하고 있다면 끝지점을 줄여버린다.
     * 만약에 어느쪽도 포함되어있지 않은 좋은수라면 카운트하고 끝지점 시작지점을 각각 줄이고 늘려준다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int count = 0;
        int [] arr= new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 0 ;i<n;i++){
            int startIndex = 0;
            int endIndex = n-1;
            while(startIndex<endIndex){
                if(arr[startIndex]+arr[endIndex]>arr[i]){
                    endIndex--;
                }else if(arr[startIndex]+arr[endIndex]<arr[i]){
                    startIndex++;
                }else{
                    if(startIndex == i){
                        startIndex++;
                    }else if(endIndex == i){
                        endIndex--;
                    }else{
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
