import java.util.*;
import java.io.*;
public class b16926 {
    static int [][] map;
    static StringTokenizer stk;
    static int N;
    static int M;
    static int R;

    static int [] dy = {0,1,0,-1};
    static int [] dx = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        for(int i= 0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        // 무조건 가로세로 둘 중 작은값은 하나는 2의 배수이므로, 즉 둘중 작은값에 /2를 하면 총 몇번 안으로 들어가야 하는지 알 수 있다.
        // 왜냐하면 뭐 어쨌건 둘 중 하나가 2의 배수이면 안쪽 돌려야할 원소도 -2 빼준 길이가 되므로
        // 총 돌려야 하는 횟수를 가로세로 중 짧은 쪽에 /2 한 값이다.
        // 이런 문제는 일단 한번 예제값을 돌려보고 생각하면 된다.
        // 가로축 범위와 세로축 범위가 안쪽으로 들어갈때마다 최소는 안쪽으로 들어간 시작원소
        // 최대는 원래 최대길이보다 안쪽으러 들어간 횟수만큼이 된다.
        // 그렇게 해서 윗줄 부터 앞으로 땡기고, 다땡기고 모서리를 만났을 때 이제 다음방향인 오른쪽 벽에서 밑에껄 땅겨온다.
        // 다 당겨왔으면 빈자리가 하나 생기는데 이는 무조건 y축으로 1만큼 더해진 곳 이다.
        int count = Math.min(N,M)/2;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<count;j++){
                int y = j;
                int x = j;


                int temp = map[y][x];
                int index = 0;
                while(index < 4){
                    int nx = x+dx[index];
                    int ny = y+dy[index];
                    if(ny<N-j && ny>=j && nx<M-j && nx>=j){
                        map[y][x] = map[ny][nx];
                        x = nx;
                        y = ny;

                    }else{
                        index++;
                    }
                }
                map[j+1][j] = temp;
            }
        }

        for(int i = 0;i<N;i++){
            for(int j= 0;j<M;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
