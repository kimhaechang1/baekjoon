import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17298 {
    // 문제 분석하기
    /*
    * 시간제한이 1초이므로 1억번의 연산횟수를 가지고 있다.
    * 대신 수열의 개수가 100만개 이다.
    * 단순히 반복문을 2개 써서 풀 수 없다.
    * 마지막 원소에 대한 오큰수는 언제나 -1이 된다. 즉, 없다.
    * 0 1 2 3
    * 3 5 2 7
    * 5 7 7 -1
    * 문제를 해결함에 있어서
    * 반복문을 수행할 때, 지목된 원소와 바로 오른쪽 원소를 비교한다.
    * 여기서 오른쪽 원소가 크다면, 지목된 원소의 인덱스번호에 해당하는 오큰수가 정해진다.
    * 만약 오큰수가 정해지지 않는다면 해당 인덱스번호에 대한 임시저장이 필요한데
    * 이 때 스택에 저장 해 둔다. 어짜피 순차적으로 진행되므로 굳이 스택이 아니어도 로직상 문제는 없다.
    * 그 다음번에 숫자에서 오큰수를 찾게 되면, 스택이 비어있으면 곧바로 오큰수로 지정하면되지만
    * 스택이 비어있지않으면 빌때까지 값을꺼내고 그 인덱스번호에 해당하는 오큰수를 찾은 값으로 지정한다.
    * 마지막 원소는 바로 -1를 넣어준다. 비교할 대상이 없기 때문에
    */

    // 손으로 풀어보기
    /*
    * N = 4로 주어지고, 원소가 3 5 2 7 일 경우
    * 0번째 원소 3이며 스택이 현재 비어있고, 오른쪽원소인 5보다 작으므로, 5를 오큰수로 지정
    * 1번째 원소 5이며 스택이 현재 비어있고, 오른쪽원소인 2보다 크므로, 스택에 인덱스번호 저장
    * 2번째 원소 2이며 스택이 현재 비어있지않고, 오른쪽원소인 7보다 작으므로, 7을 오큰수로 지정 및 스택이 빌때까지 팝을 해주며 오큰수 지정
    * 3번째 원소는 스택에 인덱스번호 저장만 해두고 나중에 남은원소 후처리 시 -1을 오큰수 배열에 저장
    */

    // 슈도코드 작성
    /*
    * int N : 수열의 크기
    * int []nums : 수열을 담을 크기 N의 배열
    * int [] okuen : 오큰수가 담길 배열
    * Stack<Integer> stack : 임시 인덱스번호 저장장소
    * for(int i : 0~N){
    *   nums배열에 수열 담기
    * }
    * 스택에 첫 번째 인덱스번호를 넣어둔다.
    * for(int i : 1~N){
    *   현재 for문은 스택에 담겨있는 번호에 해당하는 원소의 오큰수를 찾아주는 반복을 수행한다.
    *   if(스택 비어있는지?){
    *      스택에 i-1 넣기
    *   }
    *   if(스택에 피크 번호에 해당하는 원소값 < nums[i]){
    *       while(스택이 비거나 스택에 피크 번호에 해당하는 원소값 > nums[i]까지) nums[stack.pop()] = nums[i];
    *   }else{
    *       스택에 i 넣기 : 현재 num[i]는 오큰수가 아니다, 즉, 이미 스택에 저장되어있는 놈들과 같은 오큰수를 가진다는 의미
    *   }
    * }
    * while(스택이 빌때까지) nums[stack.pop()]= -1*/

    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int []okuen = new int[n];
        int []nums = new int[n];
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        okuen[n-1] = -1;
        for(int i = 0 ;i<n;i++){
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i = 0;i<n;i++){
            while(!stack.empty() && nums[stack.peek()]<nums[i]) okuen[stack.pop()] = nums[i];

            stack.push(i);

        }
        while(!stack.empty()) okuen[stack.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int k : okuen){
            sb.append(k).append(" ");
        }
        System.out.println(sb);
    }
}
