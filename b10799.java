import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i= 0;i<str.length();i++){
            if(str.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if(str.charAt(i) == ')'){
                stack.pop();
                if(str.charAt(i-1) == '('){
                    count +=stack.size();
                }else{
                    count+=1;
                }
            }
        }

        System.out.println(count);
    }
}

/*
스택문제라는걸 짐작하였다.
replaceAll로 레이저를 전부 L로 바꿔서 풀려고했으나, 코딩 과정도 복잡해졌고 이상하게 풀렸다.
당연히 틀렸고

레이저기준으로 왼쪽으로 보았을때 파이프가 몇개씩 생겨나는지를 그림을 그려서 확인한다면
각 레이저를 맞땋드렸을 경우 스택 속 크기만큼 파이프가 생겨나는걸 알 수 있다.
만약에 오른쪽 괄호를 또 만났다면, 오른쪽으로 파이프가 하나씩 추가 되어야 함을 의미한다.
왜냐하면 레이저가 파이프의 끝에 있진 않기 때문이다.
*/
