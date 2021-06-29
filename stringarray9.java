import java.io.*;
import java.util.*;

public class stringarray9 {
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(bf.readLine());
        String []s1 = new String[max];
        boolean [] isConti = new boolean[max]; // 들어온 문자열에 따라 true면 연속된문자가 있는것으로 정의
        for(int i=0;i<max;i++){
            s1[i]=bf.readLine();
            isConti[i]=true;
        }
        for(int i=0;i<max;i++) { 
            char[] tmp = s1[i].toCharArray();  // 문자열을 여러 문자로 쪼개어서 만약 어떤 문자가 4개가 나오는 문자열이라면
                for (char ch : tmp) {
                    int sum1 = 0;
                    int sum2 = 0;
                    int t = 0;
                    int st = s1[i].indexOf(ch);
                    for (int j = 0; j < tmp.length; j++) { // 그 문자가 몇번 몇번 인덱스에 나오는지 실제 인덱스의 합을 구하고 : sum2
                        if (tmp[j] == ch) {
                            sum2 += j;
                            t++;
                        }
                    }
                    for (int j = st; j < st + t; j++) { // 그 문자가 개수만큼 연속되었을 경우 가상의 인덱스의 합을 구하여 : sum1
                        sum1 += j;
                    }
                    if (sum1 != sum2) { //만약 다르다면 연속된 문자가 아닌 문자열이므로 
                        isConti[i]=false; // 연속된 문자가 아닌 문자열로 배열에 저장
                    }
                }
        }
        int count=0;
        for(int i=0;i<max;i++){
            if(isConti[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
