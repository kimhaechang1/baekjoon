import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b10828 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception {
        Stack<Integer> s = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            String query = stk.nextToken();
            if(query.equals("push")){
                int x = Integer.parseInt(stk.nextToken());
                s.push(x);
            }else if(query.equals("pop")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.pop()).append("\n");
                }
            }else if(query.equals("size")){
                sb.append(s.size()).append("\n");
            }else if(query.equals("empty")){
                if(s.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(query.equals("top")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
