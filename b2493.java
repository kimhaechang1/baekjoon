import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
class Tower{
    int index;
    int h;
    public Tower(int index, int h){
        this.index= index;
        this.h = h;
    }
}
public class b2493 {
    // 다시 풀어볼 것
    /*
    * 클래스를 이용한 풀이, 스택 두개를 사용한 풀이가 있다.
    * 내가 못풀었던 이유 : 타워의 길이를 전부 저장하고 뒤에서부터 풀려고해서 많이 헷갈린듯 함
    * 앞으로 인덱스 : 값 형태라면 클래스를 새로만드는 방식을 사용 해 볼것
    * 스택을 입출력 순서 용으로만 사용하진 말것
    */
    static StringTokenizer stk;
    static void solution2(String nums, int length){
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        StringTokenizer st = new StringTokenizer(nums);
        for (int i = 1; i <= length; i++) {			//탑이 1번 부터 시작하므로
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                if (!stack.empty()) {			//스택 안에 탑 있을 경우
                    int top = stack.peek();
                    if (top > num) {
                        System.out.print(index.peek() + " ");
                        stack.push(num);
                        index.push(i);
                        break;
                    } else { // num보다 작으면 어차피 num에 가려 필요없으므로 삭제
                        stack.pop();
                        index.pop();

                    }
                } else { // 스택 비어있을 경우
                    System.out.print("0 ");
                    stack.push(num);
                    index.push(i);
                    break;
                }

            }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> s = new Stack<>();
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        String nums = bf.readLine();
        stk = new StringTokenizer(nums);
        solution2(nums,n);
        for(int i = 1;i<=n;i++){
            int h = Integer.parseInt(stk.nextToken());
            if(s.isEmpty()){
                sb.append("0").append(" ");
                s.push(new Tower(i, h));
            }else{
                while(true){
                    if(s.isEmpty()){
                        sb.append("0").append(" ");
                        s.push(new Tower(i,h));
                        break;
                    }
                    Tower tower = s.peek();
                    if(tower.h > h){
                        sb.append(tower.index).append(" ");
                        s.push(new Tower(i,h));
                        break;
                    }else{
                        s.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
