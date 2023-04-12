
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b5648 {
    /*
    * 숫자들을 문자열로 받아서 reverseOrder 한 후
    * long로 파싱하여 새로 배열로 받는다.
    * 그리고 그 배열을 Arrays.sort()로 오름차순 정렬 하여 출력한다.
    * 숫자들을 받는 배열은 long이어야 한다.
    * 자꾸 no such Element 에러가 발생한다
    * 이런식으로 입력방식이 좀 복잡한 경우 Scanner를 써볼 생각도 하자
    * StringBuilder 에 값을 넣고 reverse함수를 돌리면 뒤집어진다.*/
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        long [] l = new long[n];
        for(int i = 0;i<n;i++){
            StringBuilder sb =new StringBuilder();
            sb.append(sc.nextLong());
            sb.reverse();
            l[i] = Long.parseLong(sb.toString());
        }
        Arrays.sort(l);
        StringBuilder t = new StringBuilder();
        for(long k : l) t.append(k).append("\n");
        System.out.println(t);
    }
}
