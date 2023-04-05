import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class b1406 {
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        /*
        * 노드의 중간삽입이 포함되어있다 -> 연결리스트를 사용한다
        * 커서에 대해 움직인다 -> ListIterator 사용
        * 처음에 ListIterator.add()로 문자들을 모두 넣어준 후
        * 커서를 움직이는 각각의 명령어를 처리하고 최종문자열을 출력한다.
        * ListIterator 에서 remove()는 결국 오른쪽 것을 없앤다.
        * 따라서 커서 왼쪽을 없애고 싶으면 왼쪽에 원소가 있는지 확인하고 왼쪽으로 커서를 옮긴 후 없앤다.
        */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> listIterator = list.listIterator();
        for(char c : input.toCharArray()) listIterator.add(c);
        for(int i = 0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            String query = stk.nextToken();
            if(query.equals("L")){
                if(listIterator.hasPrevious()){
                    listIterator.previous();
                }
            }else if(query.equals("D")){
                if(listIterator.hasNext()){
                    listIterator.next();
                }
            }else if(query.equals("B")){
                if(listIterator.hasPrevious()){
                    listIterator.previous();
                    listIterator.remove();
                }

            }else{
                char p = stk.nextToken().toCharArray()[0];
                listIterator.add(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        System.out.println(sb);
    }
}
