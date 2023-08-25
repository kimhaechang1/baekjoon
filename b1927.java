import java.util.*;
import java.io.*;

public class b1927 {
    static int N;
    static int [] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            if(a == 0){
                if(pq.size() == 0){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(a);
            }
        }
        System.out.println(sb);
    }
}
