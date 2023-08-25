import java.util.*;
import java.io.*;

public class b2658 {
    static int [][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        map = new int[10][10];
        for(int i=0;i<10;i++){
            String t = bf.readLine();
            for(int j = 0;j<10;j++){
                map[i][j] = t.charAt(j)-'0';
            }
        }
        // 직각 이등변 삼각형의 조건
        // 먼저 주어진 도형이 삼각형인가 검사
        // 적어도 한 변은 수평선 또는 수직선이다.
        // 그리고 나서 밑변이 홀수고 위 꼭지점으로부터 x또는 y좌표를 기준으로 밑변이
    }
}
