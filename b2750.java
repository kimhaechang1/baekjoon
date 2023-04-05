import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2750 {
    static void insertionSort(int [] arr){
        for(int i = 1;i<arr.length;i++){
            int insert = arr[i];
            int insertIndex = i;
            for(int k = i-1;k>-1;k--){
                if(arr[k]<insert){
                    insertIndex = k+1;
                    break;
                }
                if(k == 0) insertIndex = 0;
            }
            for(int k = i;k>insertIndex;k--){
                arr[k] = arr[k-1];
            }
            arr[insertIndex] = insert;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        insertionSort(arr);
        for(int j: arr) System.out.println(j);

    }
}
