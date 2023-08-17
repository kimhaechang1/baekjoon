import java.util.*;
import java.io.*;

public class b10851 {
    static int [] arr;
    static int [] find;
    static int N;
    static int M;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        stk = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        M = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);
        find = new int[M];
        stk =new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            find[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i= 0;i<M;i++){
            if(binarySearch(find[i])){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
    static boolean binarySearch(int find){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = (start+end)/2;
            if(arr[middle] < find){
                start = middle+1;
            }else if(arr[middle] == find){
                return true;
            }else{
                end = middle-1;
            }
        }
        return false;
    }

}
