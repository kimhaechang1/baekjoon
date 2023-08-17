import java.util.*;
import java.io.*;
public class b2580 {
    static int[][] map;
    static StringTokenizer stk;
    static void check(){
        int [] now = find();
        if(now[0] == -1){
            print();
            System.exit(0);
        }
        for(int i =1;i<=9;i++){
            if(isCan(now, i)){
                map[now[0]][now[1]] = i;
                check();
                map[now[0]][now[1]] = 0; // 원본이 훼손되었으므로 원복
            }
        }
    }
    static boolean isCan(int [] now, int number){
        int y = now[0];
        int x = now[1];
        for(int i=0;i<9;i++){
            if(map[y][i] == number || map[i][x] == number) return false;
        }
        int sy = (y/3)*3;
        int sx = (x/3)*3;

        for(int i = sy;i<sy+3;i++){
            for(int j = sx;j<sx+3;j++){
                if(map[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    static int [] find(){
        for(int i= 0;i<9;i++){
            for(int j= 0;j<9;j++){
                if(map[i][j]== 0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    static void print(){
        for(int i=0;i<9;i++){
            for(int j= 0;j<9;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        // 0,0에서부터 선별에 들어간다.
        // 그다음엔 0,1, 0,2 ... 0,8까지 검사 후 0,9가 되면 높이를 하나 올려주고 너비는 0으로 만든다.
        // 그리고 재귀호출을하여 추가 검사를 진행한다. 만약 높이마저 9가 되어버린다면 종료시킨다.
        // 좌표값이 0인곳을 만난다면 가로줄 검사 세로줄 검사 해당 작은 스도쿠판 내 검사를 진행한다.
        // 해당 좌표에 들어갈 수 있는 후보들을 (1~9)를 이용하여 세로줄 검사 가로줄검사 스도쿠 판 내 검사를 진행한다.
        // 만약에 중복되지 않은 수를 찾았다면 해당 수를 일단 좌표에 넣고, 너비+1을 검사한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i=0;i<9;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j= 0;j<9;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        check();
    }
}
