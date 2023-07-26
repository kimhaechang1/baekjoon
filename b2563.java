import java.io.*;
import java.util.*;
public class b2563 {
    static int N ;
    static int maxValue;
    static int [][] map;

    static boolean [][] v;
    public static void main(String[] args) throws Exception{
        // 크기가 100X100으로 고정되어있는 도화지
        // 그기에다가 한칸의 길이는 1, 그 칸은 정사각형이라 넓이가 1
        // 결론 : 현재 영역되어있는 칸들의 개수가 곧 넓이다!
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        maxValue = 0;

        v = new boolean[101][101];
        map = new int[101][101];
        for(int i = 1;i<N+1;i++){
            String [] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[0]);
            for(int j= y;j<y+10;j++){
                for(int k = x;k<x+10;k++){
                    if(!v[j][k]){
                        maxValue++;
                        v[j][k]= true;
                    }
                }
            }
        }
        System.out.println(maxValue);
    }
}

