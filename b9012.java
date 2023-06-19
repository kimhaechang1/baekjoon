import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ;i<T;i++){
            stack = new Stack<>();
            String str  = bf.readLine();
            boolean isError = false;
            for(char ch : str.toCharArray()){
                if(ch == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        isError = true;
                    }
                }else{
                    stack.push(ch);
                }
            }
            if(!stack.isEmpty()) isError = true;
            if(isError){
                sb.append("NO").append("\n");
            }else{
                sb.append("YES").append("\n");
            }

        }
        System.out.println(sb);
    }
}
