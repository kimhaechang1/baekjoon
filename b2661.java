import java.util.*;
import java.io.*;
public class b2661 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dfs("");
        // 3 2 1 2 1
        // 0 1 2 3 4 5 6 7 8
    }
    static void dfs(String res){
        if(res.length()==N){
            System.out.println(res);
            System.exit(0);
        }
        for(int i= 1;i<=3;i++){
            if(check(res+i)){
                dfs( res+i);
            }
        }
    }
    static boolean check(String number){
        //System.out.println(number.length());
        for(int i= 1;i<=number.length()/2;i++){ // 반씩 쪼갤 문자열의 길이를 결정
            // 만약 4라면 처음에 1씩 비교하는데 이 때, 그전까지 1씩 비교했던건 신경안쓰므로
            // 맨 뒤에서 1뺀만큼부터 시작하는 substring이면 맨뒤 숫자가 나오고
            // 그리고 2뺀만큼부터 1뺀만큼까지이면 맨뒤에서 2번째 숫자가 나온다.
            // 그리고 반씩 쪼갤 문자열 길이가 1증가하면 2개 2개씩 비교하게 된다.
            // 뒷 인덱스부터 계산하면 좀 편하다
            String t1 = number.substring(number.length()-i);
            String t2 = number.substring(number.length()-2*i, number.length()-i);
            //System.out.println(t1 +", "+t2);
            if(t1.equals(t2)) return false;
        }
        return true;
    }
}
