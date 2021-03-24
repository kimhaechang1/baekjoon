import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class array2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer []n = new Integer[9];
        for(int i=0;i<9;i++){
            n[i]=Integer.parseInt(br.readLine());
        }
        List<Integer> l = new ArrayList<>(Arrays.asList(n));
        Collections.sort(l);
        for(int i=0 ;i<9;i++){
            if(l.get(8)==n[i]){
                System.out.println(n[i]);
                System.out.println(i+1);
            }
        }
    }
}