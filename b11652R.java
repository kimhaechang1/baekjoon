import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11652R {
    /*
    * long 으로 된 카드배열을 만들고
    * 정렬을 돌린다.
    * 카드배열을 하나씩 꺼내면서 현재 카운팅 중인 숫자와 카운팅 한 개수를 센다
    * 만약 현재 카운팅한 개수가 같다면 현재 카운팅인 숫자를 교체한다.
    * 못풀었다.
    * 발상은 해냈지만 코드 구현화에 실패함
    * 이유는 0번 숫자카드에 대한 전처리를 할 생각을 못했고
    * 어떻게 처리할지에 대한 for문 내부로직은 생각해낸것과 동일했지만
    * 최대 개수를 가지는 숫자를 갱신하는 방법을 떠올리지 못했다.
    * 배열을 순회하면서 특정조건의 최대/최소를 갱신할 때에는
    * 첫번째 원소를 전처리하는 방법도 고려해봐야 한다.*/
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long [] number = new long[n];
        for(int i= 0;i<n;i++){
            number[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(number);
        int presentCounting = 1; //
        long presentCountNum = number[0]; // 현재 카운팅중인 숫자
        int countingMax = 1; // 현재 최대개수
        for(int i = 1;i<n;i++){
            if(number[i] == number[i-1]){
                presentCounting++;
            }else{
                presentCounting= 1;
            }
            if(presentCounting > countingMax){
                presentCountNum = number[i];
                countingMax = presentCounting;
            }
        }
        System.out.println(presentCountNum);
    }
}
