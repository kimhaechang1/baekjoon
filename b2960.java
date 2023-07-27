import java.util.*;
import java.io.*;
public class b2960 {
    static int N;
    static boolean []isPrime;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[]b = bf.readLine().split(" ");
        N = Integer.parseInt(b[0]);
        int K = Integer.parseInt(b[1]);
        isPrime = new boolean[N+1];
        int count = 0;
        int delNum = 0;
        for(int i = 2;i<=N;i++){
            if(isPrime[i]) continue;
            for(int k = i;k<=N;k=k+i){
                if(!isPrime[k]){
                    isPrime[k] = true;
                    count++;
                    if(count == K){
                        delNum = k;
                        break;
                    }
                }
            }
            if(count == K) break;
        }
        System.out.println(delNum);
    }
}
