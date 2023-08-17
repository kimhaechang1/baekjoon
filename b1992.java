import java.util.*;
import java.io.*;

public class b1992 {
    static int [][] map;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        // 제일 큰 영역에서 부터 4분할로 분할하고
        // 영역이 잡혔을 때 마다 영역 내 0과 1의 상태를 측정한다.
        // 0으로만 이루어져 있다면 0을 출력하고
        // 1이 하나라도 섞여 있다면 괄호를 연다.
        // 최소 사이즈는 1이 될때까지이다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i= 0;i<N;i++){
            String t = bf.readLine();
            for(int j = 0;j<N;j++){
                map[i][j] = t.charAt(j)-'0';
            }
        }
        dfs(0,0,N);
        System.out.println(sb);
    }
    static void dfs(int y, int x, int len){
        int s= 0;
        // 영역의 상태를 영역내 원소의 합으로 구한다.
        for(int i= y;i<y+len;i++){
            for(int j = x;j<x+len;j++){
                s+=(map[i][j]);
            }
        }
        if(s == 0){  // 합이 0이다 즉, 영역내 모든 원소가 0이라는 뜻
            sb.append(0);
        }else if(s == len*len){ // 합이 size*size이다 즉, 영역내 모든 원소가 1이라는 뜻
            sb.append(1);
        }else{
            int half = len/2; // 다음 4분할 영역으로 들어가야한다 즉, 현재상태에 영역의 원소가 0과 1로 섞여있다는 뜻
            sb.append("("); // 괄호를 열어서
            dfs(y,x,half); // 왼쪽위
            dfs(y,x+half,half); // 오른쪽 위
            dfs(y+half,x,half ); // 왼쪽아래
            dfs(y+half, x+half,half); // 오른쪽 아래를 또 살펴보고
            sb.append(")"); // 그기서 만약 모두 리턴났다면 현재상태의 압축을 종료한다. 그 의미로 닫는 소괄호를 추가한다.
        }
    }
}
