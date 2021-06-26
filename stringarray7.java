import java.io.*;
import java.util.*;
public class stringarray7 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char []alpha = br.readLine().toCharArray();
        int sum=0;
        for(int i=0;i<alpha.length;i++){
            if(alpha[i]-'A'<3){ //2
                sum+=3;
            }
            else if(alpha[i]-'A'<6&&alpha[i]-'A'>2){ //3
                sum+=4;
            }
            else if(alpha[i]-'A'<9&&alpha[i]-'A'>5){ //4
                sum+=5;
            }
            else if(alpha[i]-'A'<12&&alpha[i]-'A'>8){ //5
                sum+=6;
            }
            else if(alpha[i]-'A'<15&&alpha[i]-'A'>11){ //6
                sum+=7;
            }
            else if(alpha[i]-'A'<19&&alpha[i]-'A'>14){ //7
                sum+=8;
            }
            else if(alpha[i]-'A'<22&&alpha[i]-'A'>18){ //8
                sum+=9;
            }
            else if(alpha[i]-'A'<26&&alpha[i]-'A'>21){ //9
                sum+=10;
            }
        }
        System.out.println(sum);
    }
}
