import java.io.*;
import java.util.*;
public class b11723 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<M;i++){
            String [] q = bf.readLine().split(" ");
            if(q[0].equals("add")){
                set.add(Integer.parseInt(q[1]));
            }else if(q[0].equals("check")){
                if(set.contains(Integer.parseInt(q[1]))){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(q[0].equals("remove")){
                set.remove(Integer.parseInt(q[1]));
            }else if(q[0].equals("toggle")){
                if(set.contains(Integer.parseInt(q[1]))){
                    set.remove(Integer.parseInt(q[1]));
                }else{
                    set.add(Integer.parseInt(q[1]));
                }
            }else if(q[0].equals("all")){
                for(int j = 1;j<=20;j++){
                    set.add(j);
                }
            }else if(q[0].equals("empty")){
                set.clear();
            }

        }
        System.out.println(sb);
    }
}
