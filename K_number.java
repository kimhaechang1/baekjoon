import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class K_number {
    public static int[] solution(int[] array, int [][]commands){
        int i,j,k;
        int [] answer = new int[commands.length];
        int a=0;
        while(a!=commands.length){
            int s=0;
            i=commands[a][0]-1;
            j=commands[a][1];
            k=commands[a][2]-1;
            Integer [] p = new Integer[j-i];
            for(int b=i;b<j;b++){
                p[s]=array[b];
                s++;
            }
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(p));
            Collections.sort(list);
            answer[a] = list.get(k);
            a++;
        }
        return answer;
        /* best answer
        Arrays.copyOfRange(array, startIndex, endIndex) : 배열을 인덱스 범위만큼 짜름
        Arrays또한 sort 메서드 가지고 있다.
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
        */
    }

    public static void main(String[] args) {
        int a[]={1,5,2,6,3,7,4};
        int b[][]={{2,5,3},{4,4,1},{1,7,3}};
        int []rt;
        rt = solution(a,b);
        for(int k : rt){
            System.out.println(k);
        }
    }
}


