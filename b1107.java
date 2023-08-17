import java.util.*;
import java.io.*;
public class b1107 {
    static boolean [] numbers;
    static int min;
    static int minValue;
    static int len;
    static StringTokenizer stk;
    static int find;
    static int bugc;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        // 남은 숫자키패드를 이용하여 가장 근접한 수를 만든다.
        String temp = bf.readLine();
        len = temp.length();
        find = Integer.parseInt(temp);
        bugc = 0;
        bugc = Integer.parseInt(bf.readLine());
        numbers = new boolean[10];
        minValue = Integer.MAX_VALUE;
        min = Integer.MAX_VALUE;
        int result= 0;
        if(bugc == 0){
            // 버그가 아에 없는경우
            if(find == 100){
                // 찾는 숫자가 시작숫자와 동일한지 체크
                result = 0;
            }else{
                if(Math.abs(find-100) < len){
                    // 100에 이미 가까운 숫자면 - 버튼이나 + 버튼 조작하는게 더 빠를수도 있음
                    result = Math.abs(find-100);
                }else{
                    // 그게 아니라면 숫자를 직접입력하는게 빠른것
                    result = len;
                }

            }

        }else if(bugc !=0){
            // 버그가 있는 경우
            stk = new StringTokenizer(bf.readLine());
            for(int i= 0;i<bugc;i++){
                // 버그가 있는 숫자 입력
                numbers[Integer.parseInt(stk.nextToken())] = true;
            }
            if(find == 100){
                // 이때도 마찬가지로 시작 채널번호인 100과 동일 한 경우
               result = 0;
            }else{
                if(bugc != 10){
                    // 10개 다 고장이 아닌경우
                    // 1의 자리수 2의자리수 ... 목표치 보다 하나 더 큰 자리수까지
                    // 중복조합을 통해 고장안난 숫자를 가지고 값을 만들고
                    // 그 값이 찾으려는 값보다 가장 가까운것을 찾는다.
                    // 이 때 중요한것은 목표로부터 차이를 가졌더라도 숫자의 길이가 짧은것이 더 유리하다.
                    for(int i= 1;i<=len+1;i++){
                        dfs(0,0,i);
                    }
                    result = String.valueOf(minValue).length();
                    // 어쨋든 고장안난 버튼으로 눌렀으니까 그 버튼 누른 횟수는 숫자길이와 같다.
                }else{
                    // 만약 모든버튼이 고장인 경우는 시작하는 채널번호인 100번부터 목표까지 닿아야 한다.
                    minValue = 100;
                }
                // 어쨋던 정해진 minValue값에서 목표치까지의 차를 결과값에 더한다.
                result+=Math.abs(minValue-find);
                if(result > Math.abs(100-find)){
                    // 만약 최종결과가 100에서 목표치 가는것보다 더 많이 눌러야 한다면
                    result = Math.abs(100-find);
                }
            }
        }
        System.out.println(result);

    }
    static void dfs(int depth, int value, int N){
        if(depth== N){
            if(min > Math.abs(find - value)){
                min = Math.abs(find - value);
                minValue = value;
            }
            return;
        }
        for(int i = 0;i<10;i++){
            if(numbers[i]) continue;
            dfs(depth+1, value+(int)( i* Math.pow(10,depth)),N);
        }
    }
}
