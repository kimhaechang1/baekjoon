import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int n= Integer.parseInt(bf.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i = 0;i<n;i++){
            String [] prompt = bf.readLine().split(" ");
            String p = prompt[0];
            if(p.equals("push_back")){
                d.addLast(Integer.parseInt(prompt[1]));
            }else if(p.equals("push_front")){
                d.addFirst(Integer.parseInt(prompt[1]));
            }else if(p.equals("pop_front")){
                if(d.isEmpty()) sb.append(-1).append("\n");
                else sb.append(d.pollFirst()).append("\n");
            }else if(p.equals("pop_back")){
                if(d.isEmpty()) sb.append(-1).append("\n");
                else sb.append(d.pollLast()).append("\n");
            }
            else if(p.equals("front")){
                if(d.size() == 0) sb.append(-1).append("\n");
                else sb.append(d.peekFirst()).append("\n");
            }else if(p.equals("back")){
                if(d.size() == 0) sb.append(-1).append("\n");
                else sb.append(d.peekLast()).append("\n");
            }else if(p.equals("size")){
                sb.append(d.size()).append("\n");
            }else if(p.equals("empty")) {
                if (d.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

    }
}
