import java.util.*;
import java.io.*;
public class b1795 {
    static int jac;
    static int moc;
    static int L;
    static int C;
    static char [] res;
    static char [] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;
    static void comb(int depth, int start){
        if(depth == L){
            jac = 0;
            moc = 0;
            for(char c : res){
                if( c == 'a' || c =='e' || c=='i' || c=='o'|| c=='u'){
                    moc++;
                }else {
                    jac++;
                }
            }
            if(moc >= 1 && jac >=2){
                sb.append(String.valueOf(res)).append("\n");
            }
            return;
        }
        for(int i=start ;i<C;i++){
            res[depth] = arr[i];
            comb(depth+1, i+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        arr = new char[C];
        res = new char[L];
        String tmp = bf.readLine();
        for(int i= 0;i<C;i++){
            arr[i] = tmp.charAt(i*2);
        }
        Arrays.sort(arr);
        comb(0,0);
        System.out.print(sb);
    }
}
