import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11931 {
    /*
    * 안정적인 시간복잡도 nlogn을 가지는 병합정렬로 문제를 해결 할 수 있다.
    */
    static void mergeSort(int [] arr, int start,int end){
        if(end-start<2){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr,mid,end);
        merge(arr, start, mid, end);
    }
    static void merge(int [] arr, int start, int mid, int end){
        int [] temp = new int[end-start];
        int l1 = start, l2 = mid, t= 0;
        while(l1 < mid && l2 < end){
            if(arr[l1]<arr[l2]){
                temp[t++] = arr[l2++];
            }else{
                temp[t++] = arr[l1++];
            }
        }
        while(l2 < end){
            temp[t++] = arr[l2++];
        }
        while(l1 < mid){
            temp[t++] = arr[l1++];
        }

        for(int i = start; i<end;i++){
            arr[i] = temp[i-start];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] arr= new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        mergeSort(arr, 0, arr.length);
        StringBuilder sb= new StringBuilder();
        for(int k : arr) sb.append(k).append("\n");
        System.out.println(sb);
    }
}
