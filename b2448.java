import java.util.*;
import java.io.*;

public class b2448 {
    static int N;
    static String [][] map;
    static void dfs(int i, int j, int len){
        if(len == 3){
            map[i][j] = "*";
            map[i+1][j-1] = map[i+1][j+1] = "*";
            map[i+2][j-2] = map[i+2][j-1] = map[i+2][j] = map[i+2][j+1] = map[i+2][j+2]="*";
        }else{
            int offset = len/2;
            dfs(i,j,len/2); // 젤 위에꺼
            dfs(i+(len/2), j+(len/2), offset); // 오른쪽 아래
            dfs(i+(len/2), j-(len/2), offset); // 왼쪽 아래
        }

    }

    public static void main(String[] args) throws Exception{
        // 분할정복 문제는 어떤 기준으로 더이상 나눌 수 없는 작은 문제까지 들어갈 수 있는지 확인하자
        // 안쪽으로 들아가다보면 삼각형이 위 왼쪽아래 오른쪽아래로 나눠 지는걸 알 수 있다.
        // 이를통해 분할하여 들어가서 마지막에 크기 3짜리 삼각형일 경우 찍어준다.
        // 나누는것은 꼭지점을 기준으로 나눈다. -> 그렇게 해야 그 중심을 기준으로 삼각형을 그릴수 있기 때문
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new String[N][N*2-1];
        dfs(0,N-1,N);
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ;i<N;i++){
            for(int j= 0;j<N*2-1;j++){
                if(map[i][j] == null) sb.append(" ");
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
