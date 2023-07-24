import java.io.*;
import java.util.*;
public class b1966 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int t= 0;t<T;t++){
            Queue<Paper> queue = new LinkedList<>();
            stk = new StringTokenizer(bf.readLine()," ");
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int [] arr = new int[n];
            stk = new StringTokenizer(bf.readLine(), " ");
            for(int i= 0;i<n;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
                queue.add(new Paper(i, arr[i]));
            }
            int count = 0;
            while(!queue.isEmpty()){
                Paper poll = queue.poll();
                boolean isCan = true;
                for(int i= 0;i<n;i++){
                    if(arr[i] > poll.value){
                        isCan = false;
                        break;
                    }
                }
                if(isCan){
                    count++;
                    arr[poll.index]= 0;
                    if(poll.index == m) break;
                }else{
                    queue.add(poll);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
class Paper{
    int index;
    int value;
    public Paper(int index, int value){
        this.index =  index;
        this.value = value;
    }
}

