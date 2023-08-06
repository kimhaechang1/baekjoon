import java.util.*;
import java.io.*;

public class b15654 {
    static int [] arr;
    static int [] res;
    static int N;
    static int M;
    static boolean [] v;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static void perm(int depth){
        if(depth== M){
            for(int a : res) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0;i<N;i++){
            if(!v[i]) {
                v[i] = true;
                int temp = res[depth];
                res[depth] = arr[i];
                perm(depth+1);
                res[depth] = temp;
                v[i] = false;
            }
        }
    }
    static void mergeSort(int [] arr, int start, int end){
        if(end-start<2){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid,end);
    }
    static void merge(int [] arr, int start, int mid, int end){
        int [] temp = new int[end-start];
        int l1 = start;
        int l2 = mid;
        int t = 0;
        while(l1 < mid && l2 < end){
            if(arr[l1] < arr[l2]){
                temp[t++] = arr[l1++];
            }else{
                temp[t++] = arr[l2++];
            }
        }
        while(l1 < mid){
            temp[t++] = arr[l1++];
        }
        while(l2 < end){
            temp[t++] = arr[l2++];
        }
        for(int i = start;i<end;i++){
            arr[i] = temp[i-start];
        }
    }

    public static void main(String [] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine(), " ");
        arr= new int[N];
        res = new int[M];
        v = new boolean[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        mergeSort(arr, 0, arr.length);
        perm(0);
        System.out.println(sb);
    }


}
