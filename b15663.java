import java.util.*;
import java.io.*;
public class b15663 {
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static boolean [] v;
    static int [] arr;
    static int [] res;
    static StringTokenizer stk;
    static void perm(int depth){
        if(depth == M){
            StringBuilder sb2 =new StringBuilder();
            for(int a : res) sb2.append(a).append(" ");
            int prev = set.size();
            set.add(sb2.toString());
            if(set.size() > prev) sb.append(sb2).append("\n");
            return;
        }
        for(int i= 0;i<N;i++){
            if(!v[i]){
                v[i] = true;
                int temp = res[depth];
                res[depth] = arr[i];
                perm(depth+1);
                res[depth] = temp;
                v[i] = false;

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        res = new int[M];
        stk = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        v = new boolean[N];
        perm(0);
        System.out.print(sb);
    }
}
