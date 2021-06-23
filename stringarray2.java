import java.io.BufferedReader;
import java.io.InputStreamReader;

public class stringarray2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        char [] ch = s1.toCharArray();
        int [] alpa = new int[26];
        for(int i=0;i<alpa.length;i++) alpa[i]=-1;
        for(char k :ch){
            for(int i=97;i<123;i++){
                if(k==i){
                    alpa[i-'a']=s1.indexOf(k);
                }
            }
        }
        for(int t : alpa) System.out.print(t+" ");
    }
}
