import java.io.*;
import java.util.*;
public class b11866 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] t = bf.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
         int n = Integer.parseInt(t[0]);
         int cM = Integer.parseInt(t[1]);
         int count = 1;
         for(int i = 1;i<n+1;i++){
             queue.add(i);
         }
         sb.append("<");
         while(!queue.isEmpty()){
             int k = queue.poll();
             if(count % cM == 0){
                 sb.append(k);
                 if(!queue.isEmpty()){
                     sb.append(", ");
                 }
             }else{
                 queue.add(k);
             }
             count++;
         }
         sb.append(">");
         System.out.println(sb);
    }
}
