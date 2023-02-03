import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2018 {
    // 문제 분석하기
    /*
    * 자연수 분할 문제로 특정 구간이 주어지고, 구간의 크기가 자유로워야 하므로 투 포인터로 해결한다.
    * 무엇보다도, N의 크기가 천만이어서 nlogn 시간복잡도로 풀 수 없다
    * 투 포인터 알고리즘에서는 스타트 포인터와 엔드포인터의 위치를 선정해야 한다.
    * 이 문제에서는 스타트 포인터와 엔드 포인터를 같이 두고 시작하는것이 좋다.
    * 왜냐하면 어짜피 1부터 더하기 시작해서 자연수의 분할을 진행 해야하기 때문이다.
    */
    // 손으로 풀어보기
    /*
    * 투 포인터 알고리즘에서 시작지점과 끝지점의 위치를 정했으면
    * 어떨때 시작지점을 한칸 늘리고 어떨때 끝지점을 한칸 늘릴지를 결정해야 한다.
    * 결국 연속된 자연수의 합으로 N을 만들어야 하므로
    * 현재의 합이 N보다 아직 작다면 end포인터를 늘리고 현재의 합에 end포인터가 가리키는 값을 더한다.
    * 현재의 합이 N보다 크다면 현재의 합에서 start포인터가 가리키는 값을 빼고 start포인터를 늘린다.
    * 만약 N과 같다면 counter를 증가시키고 현재의 합에서 start 포인터가 가리키는 값을빼고 start 포인터를 늘린다.*/

    // 슈도 코드 작성
    /*
    startIndex = 1;
    endIndex = 1;
    sum = 1;
    count = 1;
    * while(startIndex<N){
        if(sum > N){
            sum = sum - startIndex;
            startIndex++;
        }else if(sum<N){
            endIndex++;
            sum = sum+endIndex;
        }else{
            count++;
            sum = sum-startIndex;
            startIndex++;
        }
    }*/

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int startIndex = 1; int endIndex = 1; int sum = 1; int count = 1;

        while(startIndex<N){
            if(sum<N){
                endIndex++;
                sum+=endIndex;
            }else if(sum>N){
                sum-=startIndex;
                startIndex++;
            }else{
                count++;
                sum-=startIndex;
                startIndex++;
            }
        }
        System.out.println(count);

    }
}
