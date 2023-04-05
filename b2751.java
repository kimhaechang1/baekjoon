import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2751 {
    static void merge(int []arr, int start, int mid, int end){
        int [] temp = new int[end-start];
        int l1 = start;
        int l2 = mid;
        int p = 0;
        while(l1 < mid && l2 < end){
            if(arr[l1] < arr[l2]){
                temp[p++] = arr[l1++];
            }else{
                temp[p++] = arr[l2++];
            }
        }
        while(l1 < mid){
            temp[p++] = arr[l1++];
        }
        while(l2 < mid){
            temp[p++] = arr[l2++];
        }
        for(int i = start; i<end;i++){
            arr[i] = temp[i-start];
        }
    }
    static void mergeSort(int [] arr, int start, int end){
        if(end-start<2){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int [] arr= new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        mergeSort(arr, 0, arr.length);
        for(int k : arr) sb.append(k).append("\n");
        System.out.println(sb);
    }
}
