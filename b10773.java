import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773 {
    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0;i<n;i++){
            int item = Integer.parseInt(bf.readLine());
            if(item == 0) stack.pop();
            else stack.push(item);
        }
        int sum = 0;
        for(int number : stack){
            sum+=number;
        }
        System.out.println(sum);
    }
}
