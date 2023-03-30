import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class b1744 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2)-> {
            return o2 - o1;
        });
        PriorityQueue<Integer> mn = new PriorityQueue<>();
        int c = 0;
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(bf.readLine());
            if(num < 0){
                mn.add(num);
            }else if(num == 0){
                c ++;
            }else{
                plus.add(num);
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        while(plus.size() >= 2){
            int a1 = plus.poll();
            int a2 = plus.poll();
            if(a1 + a2 > a1 * a2){
                sum2 += (a1 + a2);
            }else{
                sum2 += (a1 * a2);
            }

        }
        if(!plus.isEmpty()){
            sum2 += plus.poll();
        }
        while(mn.size() >= 2){
            int a1 = mn.poll();
            int a2 = mn.poll();
            if(a1 + a2 > a1 * a2){
                sum1 += (a1 + a2);
            }else{
                sum1 += (a1 * a2);
            }
        }
        if(!mn.isEmpty()){
            int num = mn.poll();
            if(num < 0 && c > 0){
                c--;
                num = 0;
            }
            sum1 += num;
        }
        if(sum1 < 0  && c > 0){
            sum1 = 0;
        }
        System.out.println(sum1 + sum2);
    }
}
