import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b11650 {
    /*
    * 좌표 점에 대한 클래스를 만들고 해당 클래스 배열을 형성하고
    * comparator 클래스를 익명클래스로 구현하여 내부 메서드 중 compare을 오버라이딩 한다.
    * -> Comparator 클래스 익명클래스로 구현할 때 람다식으로 그냥 바로 compare함수 구현하로 들어가도 된다.
    */
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Co [] c = new Co[n];
        for(int i = 0;i<n;i++){
           stk = new StringTokenizer(bf.readLine());
           int x = Integer.parseInt(stk.nextToken());
           int y = Integer.parseInt(stk.nextToken());
           c[i] = new Co(x, y);
        }
        Arrays.sort(c, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        StringBuilder sb = new StringBuilder();
        for(Co t : c){
            sb.append(t.x).append(" ").append(t.y).append("\n");
        }
        System.out.println(sb);
    }
}

class Co{
    int x;
    int y;
    public Co(int x, int y){
        this.x = x;
        this.y = y;
    }
}
