import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b1021 {
    static String [] buffer;
    public static void main(String[] args) throws Exception {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        buffer  = bf.readLine().split(" ");
        int maxNumber = Integer.parseInt(buffer[0]);
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int count = 0;
        for(int i = 1;i<=maxNumber;i++){
            d.addLast(i);
        }
        buffer = bf.readLine().split(" ");
        for(String num : buffer){
            int c= 0;
            int find = Integer.parseInt(num);
            while(d.getFirst()!=find){
                d.addLast(d.pollFirst());
                c++;
            }
            count+= Math.min(c, d.size()-c);
            d.pollFirst();
        }
        System.out.println(count);
        // 결국 뒤로 미뤄서 앞으로 보내던지, 앞으로 땡겨서 젤 앞으로 오던지 둘중 하나다.
        // 따라서 한쪽으로 몰아서 보낸 후 전체 크기에서 한쪽으로 몰았던 횟수를빼면 반댓방향으로 이동시킬 횟수가 나온다.
        // 그중 최소가 되는 순간에만 count를 갱신하면됨
    }
}
