import java.util.*;
import java.io.*;

public class b17829 {
    static int N;
    static int [][] map;
    static StringTokenizer stk;
    static int dfs(int i, int j, int size){
        // 사이즈가 2가 되었을때에는 2번째로 큰놈을 찾는다.
        // 아직 그게 아니라면 2가될때까지 분할하고
        // 예를들어 N = 8 이면
        // 2가 될때 까지 들어가서 2번째로 큰놈찾는행위를 해서 나온 4개의 2번째로 큰 놈들 중에서 또 2번째로 큰 놈들을 찾고
        // 그렇게 완복되면서 최종적으로 2번째로 큰 놈을 찾게만들면 된다.
        // 즉 종료조건은 사이즈가 2일때 이며, 호출조건은 그것이 아닐때 계속 파고들게 만든다.
        if(size == 2){
            int [] arr = new int[4];
            int idx = 0;
            for(int y = i;y<i+size;y++){
                for(int x = j;x<j+size;x++){
                    arr[idx++] = map[y][x];
                }
            }
            Arrays.sort(arr);
            return arr[2];
        }else{
            int [] arr = new int[4];
            arr[0] = dfs(i,j,size/2);
            arr[1] = dfs(i, j+(size/2),size/2);
            arr[2] = dfs(i+(size/2),j,size/2);
            arr[3] = dfs(i+(size/2),j+(size/2),size/2);
            Arrays.sort(arr);
            return arr[2];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        System.out.println(dfs(0,0,N));


    }
}
