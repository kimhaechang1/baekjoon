import java.io.*;
import java.util.*;
public class stringarray4 {
    public static void main(String[] args) throws Exception{
     // solution 1 : ascii 표 사용
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s =bf.readLine();
        s = s.toUpperCase(); // 어짜피 출력값은 대문자 이므로
        int []num = new int[26];
        char []ch = s.toCharArray();
        for(int k=0;k<s.length();k++){
            char tmp = s.charAt(k);
            for(char i=65;i<91;i++){
                if(tmp==i){
                    num[i-65]++;
                }
            }
        }
        int max=-1;
        char mx='?';
        //최대값 알고리즘
        for( int i=0;i<26;i++){ // num 배열의 최대값을 찾고
            if(num[i]>max){     // 최대값일 때 마다 그때의 인덱스에 해당하는 문자를 mx에 저장
                max = num[i];
                mx = (char)(i+65);
            }else if(num[i]==max){ // 최대값들과 동일한 num배열값이 존재한다면 mx를 ?로 저장
                mx = '?';
            }
        }
        System.out.println(mx);

        // solution 2 : HashMap 사용, 시간복잡도 오래걸림
        /*BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        s = s.toUpperCase();
        char []t = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int c=0;
            char ch = s.charAt(i);
            for(int k=0;k<s.length();k++){
                if(t[k]==ch){
                    c++;
                }
            }
            map.put(ch,c);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        Collections.reverse(list);
        if(list.size()==1){
            System.out.println(t[0]);
        }
        else if(list.get(0)==list.get(1)){
            System.out.println("?");
        }else{
            for(char ch : map.keySet()){
                if(list.get(0)==map.get(ch)){
                    System.out.println(ch);
                    break;
                }
            }
        }*/
    }
}
