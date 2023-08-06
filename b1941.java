import java.util.*;
import java.io.*;
public class b1941 {
    /*
    규칙을 자세히 읽고 두가지로 분리할 줄 알아야 한다.
    1. 25가지 경우의 수 중에서 7가지를 뽑는 조합
    2. 그 7가지 좌표가 서로 붙어있는지 검사 -> BFS, HashSet(뽑은 next 좌표가 현재 7가지 좌표들 중에 있어야 인접함이 인정됨)
    * */
    static char[][] ban;
    static int N = 5;
    static int M = 7;
    static int wc= 0;
    static int [][] arr = new int[25][2];
    static int [][] res = new int[7][2];
    static int [] dy = {-1,0,1,0};
    static int [] dx = {0,-1,0,1};
    static boolean [][] v;
    static Set<String> set;
    static void comb(int depth, int start){
        if(depth == 7){
            if(check()){
                wc++;
            }
            return;
        }
        for(int i= start;i<25;i++){
            res[depth] = arr[i];
            comb(depth+1,i+1);
        }
    }
    static boolean check(){
        int sc = 0;
        set = new HashSet<>();
        for(int i= 0;i<7;i++){
            set.add((Arrays.toString(res[i])));
            if(ban[res[i][0]][res[i][1]] == 'S'){
                sc++;
            }
        }
        if(sc <4){
            return false;
        }else{
            Queue<int []> queue = new LinkedList<>();
            queue.add(res[0]);
            set.remove(Arrays.toString(res[0]));
            while(!queue.isEmpty()){
                int [] now = queue.poll();
                for(int k= 0;k<4;k++){
                    int ny = now[0]+ dy[k];
                    int nx = now[1]+ dx[k];
                    if(ny < 0 || ny>=5 || nx<0 || nx>=5) continue;
                    int [] nw = {ny, nx};
                    if(set.contains(Arrays.toString(nw))){
                        set.remove(Arrays.toString(nw));
                        queue.add(nw);
                    }
                }
            }
            if(!set.isEmpty()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        ban = new char[5][5];
        for(int i= 0;i<5;i++){
            String line = bf.readLine();
            for(int j = 0;j<5;j++){
                ban[i][j] = line.charAt(j);
            }
        }
        int n = 0;
        int number = 0;
        for(int i= 0;i<25;i+=5){
            for(int j = i;j<i+5;j++){
                arr[j][0] = n;
                arr[j][1] = number++;
            }
            if(number > 0 && number % 5 == 0){
                number = 0;
            }
            n++;
        }
        comb(0,0);
        System.out.print(wc);
    }
}
