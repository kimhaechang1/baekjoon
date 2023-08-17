import java.util.*;
import java.io.*;

public class b13144 {
    static int [] cnt;
    static int [] arr;
    static int N;
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        stk = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        cnt = new int[100001];
        int l = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        // 각각의 선택지에서 카운팅을 해주는데 이 때 이전의 해당 숫자들의 카운팅 +1 한 것이
        //System.out.println(set.size());
//        for (String s : set) {
//            System.out.println(s);
//        }
    }
}
