import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b15688 {
    static void countingSort(int []arr){
        int [] temp = new int[arr.length];
        int [] freq = new int[2000001];
        for(int i= 0;i<arr.length;i++){
            freq[arr[i]+1000000]++;
        }
        int t= 0;
        for(int i = 0;i<freq.length;i++){
            while(freq[i] !=0){
                temp[t++] = i;
                freq[i]--;
            }
        }
        for(int i= 0;i<temp.length;i++){
            arr[i] = (temp[i]-1000000);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();
        countingSort(arr);
        for(int k : arr){
            sb.append(k).append("\n");
        }
        System.out.println(sb);
    }
}
