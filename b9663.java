import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class b9663 {
    static int n;
    static int [] ches;
    static int count = 0;
    static void dfs(int depth){
        if(depth == n){
            count++;
            return;
        }

        for(int i = 0;i<ches.length;i++){
            ches[depth] = i;
            if(check(depth)){
                dfs(depth+1);
            }

        }

    }
    static boolean check(int depth){
        for(int i = 0;i<depth;i++){
            if(ches[depth] == ches[i]){
                return false;
            }
            else if(Math.abs(depth - i)== Math.abs(ches[depth] - ches[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        /*
        * 퀸은 같은 행과 열에 있으면 안되며, 대각선 내에도 공격이 가능하다.
        * 그리고 퀸의 개수가 N개에 N*N크기의 체스판 이므로
        * 퀸을 놓을수 있는 경우의수는 체스판 높이당 1개씩 놓아야 한다.
        * 따라서 층에 방번호마다 돌면서 체스를 두고
        * 해당 체스가 놓을수 있어질때 다음 층에 체스를 두고
        * 만약에 놓을수 없는 상황이 오면 되돌아오는 백트래킹 DFS 방식을 사용한다.
        * 완복을 사용해야 한다.
        * */
        n = Integer.parseInt(bf.readLine());
        ches= new int[n];
        dfs(0);
        System.out.println(count);
    }
}
