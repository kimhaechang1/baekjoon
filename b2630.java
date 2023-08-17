import java.util.*;
import java.io.*;

public class b2630 {
    static int N;
    static int[][] map;
    static StringTokenizer stk;
    static int white;
    static int blue;
    static void dfs(int i, int j, int size){
        int s = 0;
        for(int y= i;y<i+size;y++){
            for(int x= j;x<j+size;x++){
                s += map[y][x];
            }
        }
        if(s == 0){
            white++;
        }else if(s == size * size){
            blue++;
        }else{
            int half = size/2;
            dfs(i,j,half);
            dfs(i+half,j,half);
            dfs(i,j+half,half);
            dfs(i+half,j+half,half);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        white = 0;
        blue = 0;
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j =0;j<N;j++){
                map[i][j]= Integer.parseInt(stk.nextToken());
            }
        }
        dfs(0,0,N);
        System.out.println(white);
        System.out.print(blue);
    }
}
