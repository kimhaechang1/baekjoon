import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b5430 {
    static String [] buffer;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0;i<t;i++){
            String answer = "";
            String prompt = bf.readLine();
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int size = Integer.parseInt(bf.readLine());
            String flag = "front";
            boolean isError = false;
            String arrString = bf.readLine();
            buffer = arrString.substring(1, arrString.length()-1).split(",");
            if(size != 0) {
                for(String num : buffer){
                    deque.add(Integer.parseInt(num));
                }
            }
            for(char p : prompt.toCharArray()){
                if(p == 'R'){
                    if(flag.equals("front")) flag = "rear";
                    else flag = "front";
                }else{
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }else{
                        if(flag.equals("rear")){
                            deque.pollLast();
                        }else{
                            deque.pollFirst();
                        }
                    }
                }
            }
            if(isError){
                System.out.println("error");
            }else{
                answer+="[";
                String [] temp = new String[deque.size()];
                int index = 0;
                while(!deque.isEmpty()){
                    String tempString = "";
                    if(flag.equals("rear")){
                        tempString = String.valueOf(deque.pollLast());
                    }else{
                        tempString = String.valueOf(deque.pollFirst());
                    }
                    temp[index++] = tempString;
                }
                String elem = String.join( ",",temp);
                answer+=elem;
                answer+="]";
                System.out.println(answer);
            }
        }
    }
    // 생각하지 못한 경우의 수로는
    // 배열의 크기가 0일때의 처리방향성 -> 0이면 데크안에 들어갈 원소가 없다
    // 즉, 스플릿함수하고 다 작동안되서 빈 문자열을 parseInt로 변환하여 넣을려는 시도를 못하게 해야한다
}
