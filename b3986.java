import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b3986 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Character> stack;
        int count = 0;
        for(int i = 0;i<n;i++){
            String str = bf.readLine();
            stack = new Stack<>();
            stack.push(str.charAt(0));

            for(int j = 1;j<str.length();j++){
                if(stack.isEmpty() || stack.peek() != str.charAt(j)){
                    stack.push(str.charAt(j));
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
