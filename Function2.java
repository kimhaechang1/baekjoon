import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Function2 {
    public static int con(int n){
        if(n<10){
            n=n+n;
        }
        else if(n>=10&&n<100){
            n=n+(n/10)+(n%10);
        }
        else if(n>=100&&n<1000){
            n=n+(n/100)+((n%100)/10)+(n%10);
        }
        else if(n>=1000&&n<10000){
            n=n+(n/1000)+((n%1000)/100)+((n%100)/10)+n%10;
        }
        return n;
    }
    public static void main(String[] args) {
        int k;
        int i;
        int m=1;
        HashSet<Integer> conn = new HashSet<>();
        for(i=1;i<=10000;i++){
            k=con(i);
            if(k<10000) {
                conn.add(k);
            }
        }
        ArrayList<Integer> c = new ArrayList<>(conn);
        Collections.sort(c);
        k=0;
        while(m!=10000){
            if(m==c.get(k)){
                k++;
            }else{
                System.out.println(m);
            }
            m++;
        }
    }
}


