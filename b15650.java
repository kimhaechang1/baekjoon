import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15650 {
    static String [] buffer;
    static int m;
    static int n;
    static int [] arr;
    static boolean [] v;
    static void dfs(int start, int depth){
        if(depth == m){
            for(int t : arr) System.out.print(t+" ");
            System.out.println();
            return;
        }
        for(int i = start;i<=n;i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        buffer = bf.readLine().split(" ");
        n = Integer.parseInt(buffer[0]);
        m = Integer.parseInt(buffer[1]);
        v = new boolean[n];
        arr =  new int[m];
        dfs(1,0);
    }
    /*
    * 방문체커 필요없이 시작번호부터 끝번호까지의 경우의수를 탐색하면된다.
    * 즉, 1에서 부터 시작해서 2,3,4 그리고 2에서 부터 시작해서 3, 4 이런식으로*/
}
