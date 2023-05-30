import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15649 {
    static int n;
    static int m;
    static int [] arr;
    static String [] buffer;
    static boolean [] v;
    static void dfs(int depth){
        if(depth == m){
            for(int t : arr) System.out.print(t +" ");
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(!v[i]){
                v[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                v[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        buffer = bf.readLine().split(" ");
        n = Integer.parseInt(buffer[0]);
        m = Integer.parseInt(buffer[1]);
        arr = new int[m];
        v = new boolean[n];
        dfs(0);

    }
    /*
    * dfs 로 푸는 순열문제이다.
    * 순열은 순서가 중요하므로 1, 2 그리고 2, 1을 뽑는것을 서로 다르게 취급한다.
    * 순열을 저장할 배열을 뽑는 개수만큼 정해주는것이 핵심*/
}
