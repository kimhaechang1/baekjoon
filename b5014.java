import java.util.*;
import java.io.*;
public class b5014 {
    static int F,S,G,U,D;
    static int res;
    static StringTokenizer stk;
    static boolean []v;
    static void bfs(int pres){
        Queue<int[]> queue =new LinkedList<>();
        queue.add(new int[]{pres, 0});
        while(!queue.isEmpty()){
            int [] p = queue.poll();
            if(p[0] == G){
                res = p[1];
                return;
            }
            if(p[0]+U <= F &&!v[p[0]+U]){
                queue.add(new int[]{p[0]+U,p[1]+1});
                v[p[0]+U]= true;
            }
            if(p[0]-D >0 && !v[p[0]-D] ){ // 0층은 없다.
                queue.add(new int[]{p[0]-D,p[1]+1});
                v[p[0]-D]= true;
            }
        }
    }
    public static void main(String[] args) throws Exception{
      BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
      stk = new StringTokenizer(bf.readLine());
      F = Integer.parseInt(stk.nextToken());
      S = Integer.parseInt(stk.nextToken());
      G = Integer.parseInt(stk.nextToken());
      U = Integer.parseInt(stk.nextToken());
      D = Integer.parseInt(stk.nextToken());
      v = new boolean[F+1];
      res =Integer.MAX_VALUE;
      if(S==G){
          System.out.println(0);
      }else if(S > G && D==0){
          System.out.println("use the stairs");
      }else if(S < G && U==0){
          System.out.println("use the stairs");
      }else {
          bfs(S);
          if (res == Integer.MAX_VALUE) {
              System.out.println("use the stairs");
          } else {
              System.out.println(res);
          }
      }
    }
}
