import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10989 {
    /*
    * 수의 개수가 천만이므로
    * 병합정렬과 퀵정렬을 한다고 해도 nlogn의 시간복잡도로는 버틸수 없다.
    * 대신 수의 범위가 1만 이하이므로 숫자 크기가 작다는 것을 확인할 수 있다.
    * 수의 범위가 작으므로 숫자의 자리수별로 크기를 비교하여 정렬하는 기수정렬을 할 수 있다.
    * 누적합 배열의 값이 원본배열에서의 인덱스가 되는데, 이 때 누적합 배열에서의 값 -1을 해야하는걸 잊으면 안된다.
    */
    static void RadixSort(int [] arr, int max){
        int j = 1;
        int cnt = 0;
        int []t = new int[arr.length];
        while(cnt != max){
            int [] temp = new int[10];
            for(int i = 0;i<arr.length;i++){
                temp[arr[i]/j%10]++;
            }
            for(int i = 1;i<temp.length;i++){
                temp[i] = temp[i-1]+temp[i];
            }
            for(int i = arr.length-1;i>-1;i--){
                t[temp[arr[i]/j%10]-1] = arr[i];
                temp[arr[i]/j%10]--;
            }
            for(int i = 0;i<arr.length;i++){
                arr[i] = t[i];
            }
            cnt++;
            j = j*10;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int []arr = new int [n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        RadixSort(arr, 5);
        StringBuilder sb= new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
