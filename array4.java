import java.io.*;
import java.util.*;
public class array4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> m = new HashMap<>();
        int num;
        int k;
        int sum=0;
        for(int i=0;i<42;i++){
            m.put(i,0);
        }
        for(int j=0;j<10;j++){
            num = Integer.parseInt(br.readLine());
            for(int i=0;i<42;i++){
                if((num%42)==i){
                    m.put(i,m.get(i)+1);
                }
            }
        }
        for(Integer value : m.values()){
            if(value!=0){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
