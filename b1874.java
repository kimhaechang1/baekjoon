import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    // 문제 분석하기
    /*
     * 문제자체에서 스택을 사용하는 문제라는 점을 암시하였고
     * 시간제한이 2초이므로 2억번의 연산 내외로 해결해야한다.
     * 여기서 숫자 개수의 범위가 10만개 이므로 n^2의 방법으로는 해결할 수 없다.
     * 첫줄에는 만들어야하는 수열의 개수
     * 둘째줄 부터 수열을 이루는 1~n이하의 정수
     * 숫자는 항상 오름차순으로 들어가므로
     * 만약에 숫자를 뽑아야하는데
     * 스택이 비어있지 않은 상황에서 pop한 숫자가 뽑아야하는 숫자보다 크다면 만들 수 없는 수열이 된다.
     */
    // 손으로 풀어보기
    /*
    * N = 5로 주어지고 수열이 1 2 5 3 4 일 경우
    * 시작숫자는 1로 초기화한다.
    * 주어진 수열만큼 반복문을 수행하며 첫번째 숫자 1이 지목되었을때
    * 스택이 비어있거나 peek값이 지목된 숫자보다 큰지? 에 대해 검사한다.
    * 현재 스택이 비어있으므로 시작숫자에서부터 지목된 숫자까지 스택에 넣어주고 pop을 한 번 실행한다.
    * 시작숫자를 2로 초기화한다.
    * 두 번째 숫자가 2로 지목되었을때
    * 스택이 비어있으므로 시작숫자에서부터 지목된 숫자까지 스택에 넣어주고 pop을 한 번 실행한다.
    * 시작숫자를 3으로 초기화한다.
    * 세 번째 숫자가 5로 지목되었을 때
    * 스택이 비어있으므로 시작숫자에서부터 지목된 숫자까지 스택에 넣어주고 pop을 한 번 실행한다.
    * 시작숫자를 6으로 초기화 한다.
    * 네 번째 숫자가 3으로 지목되었을 때
    * 스택이 비어있지 않고, peek값(= 4)이 지목된 숫자보다 크기 때문에
    * pop을 진행하는데 이 때 pop한 숫자가 지목된 숫자보다 크기 때문에 만들 수 없는 수열이 된다.
    * */
    // 슈도 코드 작성
    /*
    * int N : 수열의 개수
    * int f = 1 : 시작숫자
    * Stack<Integer> st : 스택
    * StringBuilder sb: 출력 할 문자열 생성
    * for (i : 0~N){
    *   int num : 만들어야 하는 수열 하나 받아오는
    *   if(스택이 비어있는지 || st.peek값 < num ){
    *       for(k : 시작숫자~num) st.push(k) sb.append("+").append("\n")
    *       st.pop() sb.append("-").append("\n")
    *       시작숫자 = num+1;
    *   }else{
    *       if(st.peek > num){
    *           return NO 출력
    *       }
    *       // 스택에 가장 윗단 값이 뽑아야 하는 수와 같으면 팝만 해주면 되므로
    *       st.pop()
    *       sb.append("-").append("\n")
    *   }
    * }
    * */

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int f = 1;
        for(int i = 0; i<N;i++){
            int num = Integer.parseInt(bf.readLine());
            if(stack.isEmpty() || stack.peek() < num){
                for(int k = f; k<=num;k++){
                    stack.push(k);
                    sb.append("+").append("\n");
                    f = num+1;
                }

            }else{
                if(stack.peek()>num){
                    flag = false;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        if(flag) System.out.println(sb);
        else System.out.println("NO");

    }
}
