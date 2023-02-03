import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1940 {
    // 문제 분석하기
    /*
    * 두 개의 재료의 합이 M이 되는순간의 가지수를 구하는 문제로서
    * 시간제한이 2초이기 때문에 2억번의 연산 내외로 끝내야 하는데
    * 재료의 개수가 최대 15000개 이므로 nlogn의 알고리즘을 사용하여도 문제가 없다.
    * 따라서 n의 시간복잡도로 해결해야 한다.
    * 여기서 핵심은 두 숫자의 합이 M이 되는 가짓수를 구하는 문제이기 때문에 투 포인터 알고리즘으로 접근 해 본다.*/
    // 손으로 풀어보기
    /*
     * N의 크기가 nlogn 의 정렬 함수를 사용해도 충분한 크기이므로
     * 정렬을 사용하여 재료의 크기를 오름차순 배열한다. 1 2 3 4 5 : 5
     * 여기서 시작지점과 끝지점 포인터는 각각 배열 0번과 끝번호에서 시작하고
     * 종료 조건은 두 포인터 중 start포인터가 end포인터보다 커지는 순간 종료한다.
     * 각 포인터별 늘리는 조건은
     * 두 포인터가 가리키는 값의 합이 M보다 작다면 start 포인터를 늘린다.
     * 두 포인터가 가리키는 값의 합이 M보다 크다면 end 포인터를 줄인다.
     * 만약 M과 같다면 start포인터는 늘리고 end포인터는 줄인다.
     * 여기서 핵심은 왜 start포인터와 end 포인터가 같은 곳이 아닌 양극에서 시작하냐? 이다.
     * 이 문제같은 경우 결국 가짓수를 찾는건 다른 투포인터 문제와 같으나
     * 크기가 정해진 배열안에서 돌아야 하고, 두개의 값만을 가지고 M과 비교하여야 하는데
     * 시작지점 포인터와 끝지점 포인터가 같게 되면, 끝지점 포인터가 끝에 도달했는데도 합이 M보다 작을경우를 처리해주기 복잡해진다. */

    // 슈도 코드 작성
    /*
    arr[] = {크기 N의 배열로서 정렬된 자연수들}
    startIndex = 0;
    endIndex = N-1;
    count = 0;
    while(startIndex<endIndex){

        if(두 포인터가 가리키는 합 > M){
            endIndex--;
        }else if(두 포인터가 가리키는 합<M){
            startIndex++;
        }else{
            count++;
            startIndex++;
            endIndex--;
        }
    }*/
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int startIndex = 0; int endIndex = N-1; int count = 0;
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        while(startIndex< endIndex){
            if(arr[startIndex]+ arr[endIndex]< M){
                startIndex++;
            }else if(arr[startIndex]+arr[endIndex]> M) {
                endIndex--;
            }else{
                count++;
                startIndex++;
                endIndex--;
            }
        }
        System.out.println(count);
    }
}
