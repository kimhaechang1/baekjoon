// baekjoon
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class array1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        String nums = br.readLine();
        StringTokenizer stk = new StringTokenizer(nums);
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(list);
        System.out.print(list.get(0)+" "+list.get(N-1));
    }
}
