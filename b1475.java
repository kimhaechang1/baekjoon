import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1475 {
    // 6은 9로 대체가 가능하고 9는 6으로 대체가 가능하다면
    // 결국 최소로 숫자세트를 사용해야하므로
    // 6을 사용한 횟수가 적다면 6으로 카운팅 9를 사용한 횟수가 적다면 9로 카운팅 하면된다.
    // 반례를 생각할때 문제에서 주어진 특이조건이 포함된 반례를 생각하자
    public static void main(String[] args) throws Exception{
        int [] count = new int[10];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str= bf.readLine();
        str = str.replaceAll("99","69");
        for(char num : str.toCharArray()){
            if(num-'0' == 6 || num=='9'){
                if(count[6] > count[9]) count[9]++;
                else count[6]++;
            }else{
                count[num-'0']++;
            }
        }
        int max = 0;
        for(int i : count){
            if(max < i) max = i;
        }
        System.out.println(max);
    }
}
