import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<String> stack = new Stack<>();
        int answer = 0;
        boolean isError = false;
        for(char ch : str.toCharArray()){
            if(stack.isEmpty()){
                stack.push(String.valueOf(ch));
                continue;
            }
            if(ch == '[' || ch =='('){
                stack.push(String.valueOf(ch));
            }else if(ch == ']'){
                int temp = 0;
                while(!(stack.isEmpty()) &&!(stack.peek()).equals("[")){
                    if((stack.peek()).equals("(") || (stack.peek()).equals(")") || (stack.peek()).equals("]")){
                        isError = true;
                        break;
                    }else{
                        temp += Integer.parseInt(stack.pop());
                    }
                }
                if(stack.isEmpty()){
                    isError = true;
                }else{
                    stack.pop();
                    if(temp==0) temp=1;
                    stack.push( String.valueOf(3 * temp));
                }
            }else if(ch == ')'){
                int temp = 0;
                while(!(stack.isEmpty()) && !(stack.peek()).equals("(")){
                    if((stack.peek()).equals("[") || (stack.peek()).equals(")") || (stack.peek()).equals("]")){
                        isError = true;
                        break;
                    }else{
                        temp += Integer.parseInt(stack.pop());
                    }
                }
                if(stack.isEmpty()){
                    isError = true;
                }else{
                    stack.pop();
                    if(temp==0) temp=1;
                    stack.push( String.valueOf(2 * temp));
                }
            }
            if(isError) break;
        }
        while(!stack.isEmpty()) {
            if (stack.peek().equals("(") || stack.peek().equals("[") || (stack.peek()).equals(")") || (stack.peek()).equals("]")) {
                isError = true;
                break;
            } else {
                answer +=Integer.parseInt(stack.pop());
            }
        }
        if(isError) answer = 0;
        System.out.println(answer);
        // 조건의 예외처리를 엄청 잘해줘야 하는 문제
        // 스택 문제는 스택이 비어있을경우를 우선도 높게 항상 체크해줘야 한다.
    }
}
