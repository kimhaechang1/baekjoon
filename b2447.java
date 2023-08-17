import java.util.*;
import java.io.*;

public class b2447 {
    static int N;
    static String [][] map;
    static void go(int i, int j, int len){
        // 만약에 블랭크인 경우는 블랭크의 크기가 재귀호출이 돌아가면서 len값이 원복되므로
        // 그 순간의 i,j 기준 len값 만큼 복원되야한다.
        if(len == 1){
            map[i][j] = "*";
            return;
        }
        // 높이를 3으로 나누고 가로를 3으로 나눈만큼에 대한 재귀를돌린다.
         
        for(int y = 0;y<3;y++){
            for(int x = 0;x<3;x++){
                if(!(y == 1 && x == 1)){
                    go(i+(y*len/3),j+(x*len/3), len/3);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        // 분할정복 문제
        // 더이상 나눌 수 없는 기준을 길이를 1일때로 정하고
        // 그 기준은 0,0에서 부터 현재 길이를 3*3짜리로 계속 압축한다.
        // 27길이의 좌표를 9개짜리 좌표로 분할하고 또 3개짜리 좌표로 분할하고 1개짜리 좌표까지 나누어졌을 때
        // 그 좌표에 대한 기준을 잡고 3*3으로 계속 쪼개어 들어간다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new String[N][N];
        go(0,0,N);
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == null) sb.append(" ");
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
