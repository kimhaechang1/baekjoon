import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int startIndex = 1;
        for(int i = 0;i<n;i++){
            int query = Integer.parseInt(bf.readLine());
            if(!s.isEmpty() && s.peek()>= query){
                while(s.peek()!=query){
                    s.pop();
                    sb.append("-").append("\n");
                }
                s.pop();
                sb.append("-").append("\n");
            }
            else if(startIndex <= query){
                for(int k = startIndex;k<=query;k++){
                    s.push(k);
                    sb.append("+").append("\n");
                    startIndex = k;
                }
                startIndex++;
                s.pop();
                sb.append("-").append("\n");

            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
