import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b15688 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int k : arr){
            sb.append(k).append("\n");
        }
        System.out.println(sb);
    }
}
