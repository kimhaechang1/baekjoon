import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11651 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point [] p = new Point[n];
        for(int i= 0;i<n;i++){
           stk = new StringTokenizer(bf.readLine());
           int x = Integer.parseInt(stk.nextToken());
           int y = Integer.parseInt(stk.nextToken());
           p[i] = new Point(x, y);
        }
        Arrays.sort(p, (o1, o2)->{
           if(o1.y == o2.y){
               return o1.x - o2.x;
           }
           return o1.y - o2.y;
        });
        StringBuilder sb= new StringBuilder();
        for(Point t : p){
            sb.append(t.x).append(" ").append(t.y).append("\n");
        }
        System.out.println(sb);
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

