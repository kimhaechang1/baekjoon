import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1431 {
    /*
    * comparator 클래스의 compare 메소드를 오버라이드 하여서 직접 정렬순서를 결정짓는다.
    * 문자열 배열을 받아서 각 조건에 따라 정렬 조건을 정해준다.
    * string.compareTo : 두 문자열의 문자를 위치순서대로 비교하고
    * 비교할 때 두 문자열이 같으면 0을 리턴하지만 두 문자열이 다른경우 다양한 숫자를 리턴한다.
    * 예를들어 오른쪽 피 문자열이 왼쪽 피 문자열에 순서대로 포함된 경우 두 문자열의 차 를 리턴한다.
    * 만약 포함은 되지만 순서가 틀린경우에는 아스키값 기준 같은 순서의 두 문자의 차이를 리턴한다.
    * 아에 다른문자열과 비교하는 경우에는 처음으로 틀린 지점의 아스키 값 차이를 리턴한다.
    */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String [] str = new String[n];
        for(int i = 0;i<n;i++){
            str[i]= bf.readLine();
        }
        Arrays.sort(str, (o1, o2)->{
           if(o1.length() == o2.length()){
               int sum1 = 0;
               int sum2 = 0;
               for(char t : o1.toCharArray()){
                   int checkNum = t - '0';
                   if(checkNum >= 17 && checkNum<=42){
                       continue;
                   }
                   sum1+=checkNum;
               }
               for(char t : o2.toCharArray()){
                   int checkNum = t- '0';
                   if(checkNum >= 17 && checkNum<=42){
                       continue;
                   }
                   sum2+=checkNum;
               }
               if(sum1 == sum2){
                   return o1.compareTo(o2);
               }else{
                   return sum1 - sum2;
               }
           }
           return o1.length() - o2.length();
        });
        StringBuilder sb= new StringBuilder();
        for(String s : str){
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }
}
