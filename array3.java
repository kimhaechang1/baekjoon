// baekjoon
import java.io.*;
import java.util.HashMap;

public class array3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        int k=0;
        for(int i=0;i<3;i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        String num = Integer.toString(a[0]*a[1]*a[2]);
        HashMap<Integer,Integer> fre = new HashMap<>();
        char []n = num.toCharArray();
        int[] nums = new int[n.length];
        for(int i=0;i<10;i++){
            fre.put(i,0);
        }
        for(int i=0;i<n.length;i++){
            nums[i]=Integer.parseInt(String.valueOf(n[i]));
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    fre.put(i,fre.get(i)+1);
                }
            }
        }
        for(Integer value :fre.values()){
            System.out.println(value);
        }
    }

}
