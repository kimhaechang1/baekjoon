import java.util.*;
import java.io.*;
public class b10819 {
    static int max;
    static int N;
    static int [] arr;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        stk = new StringTokenizer(bf.readLine());
        for(int i= 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        do{
            int sum = 0;
            for(int i= 0;i<N-1;i++){
                sum += (Math.abs(arr[i] - arr[i+1]));
            }
            max = Math.max(sum, max);
        }while(np(arr));
        System.out.println(max);

    }
    static boolean np(int [] arr){
        int i= arr.length-1;
        while(i > 0 && arr[i-1]>= arr[i]) i--;
        if(i == 0) return false;
        int j = arr.length-1;
        while(arr[i-1]>=arr[j]) j--;
        int t= arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = t;
        int k = arr.length-1;
        while(i< k){
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
            i++;
            k--;
        }
        return true;
    }
}
