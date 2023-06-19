import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        while(!(str = bf.readLine()).equals(".")){
            boolean isError = false;
            stack = new Stack<>();
            for(char ch : str.toCharArray()){
                if(ch == '(' || ch == '['){
                    stack.push(ch);
                }else if(ch == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        isError = true;
                        break;
                    }
                }else if(ch == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        isError = true;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) isError = true;
            if(isError){
                sb.append("no").append("\n");
            }else{
                sb.append("yes").append("\n");
            }

        }
        System.out.println(sb);
    }
}
