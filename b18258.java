import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b18258 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int recent = 0;
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            String query = stk.nextToken();
            if (query.equals("push")) {
                int X = Integer.parseInt(stk.nextToken());
                queue.offer(X);
                recent = X;
            } else if (query.equals("pop")) {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.poll()).append("\n");
            } else if (query.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (query.equals("empty")) {
                if (queue.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (query.equals("front")) {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.peek()).append("\n");
            } else {
                if (queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(recent).append("\n");
            }
        }
        System.out.println(sb);
    }
}
