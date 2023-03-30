import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164 {
    public static void main(String[] args) throws Exception{
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        for(int i = 1;i<=n;i++){
            queue.offer(i);
        }
        while(queue.size()!=1){
            queue.poll();
            int b= queue.poll();
            queue.add(b);
        }
        System.out.println(queue.peek());
    }
}
