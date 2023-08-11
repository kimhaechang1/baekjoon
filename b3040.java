import java.util.*;
import java.io.*;
public class b3040 {
    // 9명의 난쟁이 중 7명의 난쟁이의 합이 100이라면
    // 전체 9명의 난쟁이의 합에서 100만 큼 뺀 값이 나오는 두명의 난쟁이를 찾으면 된다.
    // 두명의 모자값의 합이 중요하고 딱히 순서는 상관없으므로 조합으로 해결할 수 있다.

    static int [] arr; // 9 난쟁이의 모자값을 넣을 변수
    static boolean []v; // 방문체크
    static int cha; // 찾아야할 2명의 난쟁이의 모자의 합
    static int v1; // 찾아야할 난쟁이들의 인덱스값
    static int v2;
    static void dfs(int depth, int start){
        if(depth == 2){
            int sum = 0;
            // 찾은 난쟁이들의 인덱스번호를 저장할 배열
            int [] ver = new int[2];
            int idx = 0;
            for(int i= 0;i<9;i++){
                if(v[i]){
                    sum+=arr[i];
                    ver[idx++] = i;
                }
            }
            // 선택 한 2명의 난쟁이의 모자 합을 구하고
            // 그 값이 찾는값이라면 인덱스번호를 저장
            if(sum == cha) {
                v1 = ver[0];
                v2 = ver[1];
            }
            return;
        }
        for(int i= start;i<9;i++){
            v[i] = true;
            dfs(depth+1, i+1);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 각종 초기화
        arr = new int[9];
        int sum = 0;
        for(int i= 0;i<9;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum+=arr[i];
        }
        // 찾아야할 두명의 난쟁이 모자값들의 합
       cha = sum-100;
        v = new boolean[9];
        v1 = -1;
        v2 = -1;
        dfs(0,0);
        for(int i= 0;i<9;i++){ // 조합으로 찾은 난쟁이 번호를 제외한 나머지 숫자들을 출력
            if(arr[v1] == arr[i] || arr[v2] == arr[i])continue;
            System.out.println(arr[i]);
        }
    }
}
