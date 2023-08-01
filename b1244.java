import java.util.*;
import java.io.*;
public class b1244 {
    static boolean [] s; //  스위치들의 상태를 인덱스별로 관리하기 위한 boolean형 배열
    static int N; // 스위치의 개수저장을 위한 int형 변수
    static int M; // 질의의 개수를 받을 int형 변수
    static StringTokenizer stk; 
    public static void main(String[] args) throws Exception{
        // 켜져있음 1 true, 꺼져있음 0 false
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        s = new boolean[N+1];
        stk = new StringTokenizer(bf.readLine(), " ");
        for(int i = 1;i<=N;i++){ 
            int a = Integer.parseInt(stk.nextToken());
            if(a == 1) { // 켜져있는 스위치에 대하여만 처리, 왜냐하면 boolean 배열 기본값 false
                s[i] = true;
            }
        }
        M = Integer.parseInt(bf.readLine());
        for(int i = 0;i<M;i++){
            String [] query = bf.readLine().split(" ");
            if(query[0].equals("1")){ // 남학생의 경우를 처리
                int p = Integer.parseInt(query[1]);
                for(int k = p, j = 1;k<=N;k=p*(++j)){ 
                    // 주어진 인덱스 번호부터 배수를 결정할 j만큼 곱한 곳의 값을 역으로 변경
                    s[k] = !s[k];
                }
            }else{

                int b = Integer.parseInt(query[1]);
                // 왼쪽으로 오른쪽으로 각각 이동시킬 포인터형 변수 l, r 선언
                int l = b;
                int r = b;
                boolean isFind = false; // 혹시 범위를 벗어나지 않는 선에서 비대칭을 찾았는지?
                while(true){
                    l--;
                    r++;
                    // 왼쪽 포인터가 범위 밖으로 나간경우
                    if(l < 1 && r <N){
                        for(int k = 1;k<r;k++){
                            s[k] = !s[k];
                        }
                        break;
                    }else if(l > 0 && r>N){
                        // 오른쪽 포인터가 범위 밖으로 나간경우
                        // 항상 양쪽의 포인터는 서로 멀어지는 방향으로 1씩 같이 움직이므로
                        // for문의 시작번호를 왼쪽 포인터 + 1
                        for(int k = l+1 ;k<=N;k++){
                            s[k] = !s[k];
                        }
                        break;
                    }else if(l == 1 && r ==N && s[l] == s[r]){
                        // 양끝점에 포인터가 각각 도달하였고 끝까지 대칭인 경우
                        for(int k = l ;k<=N;k++){
                            s[k] = !s[k];
                        }
                        break;
                    }
                    if(s[l] != s[r]){
                        // 비대칭을 발견 한 경우 flag변수 수정
                        isFind = true;
                        break;
                    }
                }
                if(isFind) {
                    // 비대칭을 발견한 l+1에서 r까지 싹다 역으로 바꿈
                    for (int k = l + 1; k < r; k++) {
                        s[k] = !s[k];
                    }
                }

            }
        }
        // 출력양식에 맞추기 위한 부분
        if(N <= 20){
            for(int i= 1;i<=N;i++){
                System.out.print(s[i] ? 1 + " " : 0 + " ");
            }
        }else{
            // 몇번 반복할지를 정하는 cntMax
            int cntMax = N/20;
            int cnt = 0;
            int start = 1;
            int end = 20;
            while(cnt <= cntMax){
                for(int i= start;i<=end;i++){
                    System.out.print(s[i] ? 1 + " " : 0 + " ");
                }
                System.out.println();
                cnt++;
                // 다음 for문의 범위를 지정
                // 이 때 end의 경우 20번 또 더해야하는지 검사함
                if(end + 20 >= N){
                    end = N;
                }else{
                    end +=20;
                }
                start+=20;
            }

        }

    }
}
