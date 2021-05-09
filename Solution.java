
import java.util.HashSet;

public class Solution {
    public int solution(int [] nums){
        int answer;
        int k = nums.length/2;
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){ // 중복 제거
            s.add(nums[i]);
        }
        if(k>=s.size()){
            answer=s.size(); // 중복이 제거된 배열의 수만큼 종류수를 가진다.
            /* {2,2,2,3,3,3} 인 경우도 결국 {2,2,3}이던 {3,3,2}인데,
            이렇다 할 지라도 종류는 결국 2와3 2가지 이므로 최댓값은 2이다.*/
        }else{
            answer= k; // 중복이 제거된 배열의 수가 뽑는 수 보다 많은 경우
                        // 결국 뽑는 개수는 한정되어있으므로 나머지 어떤 배열의 수와 조합하여도
                        // 문제가 없다. 따라서 뽑는수가 최대의 종류 수 이다.

        }
        return answer;

    }

    public static void main(String[] args) {
       Solution s = new Solution();
       int [] n ={3,3,1,2,5,4};
       System.out.println("정답 = "+s.solution(n));
    }
}
