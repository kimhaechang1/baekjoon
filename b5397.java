import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class b5397 {
    public static void main(String[] args) throws Exception{
        /*
        * 백스페이스 : -, 현재 커서위치에 왼쪽에 있는 문자를 지운다.
        * 화살표 입력 : <, > 왼쪽 혹은 오른쪽으로 1만큼 커서 움직임
        * 문자열을 이어붙이는데, 커서 이동을 통해 중간에 문자를 삽입할수도 있어야 함
        * LinkedList와 ListIterator로 구현가능
        * ListIterator를 활용하면 양방향으로 탐색하면서 추가 삭제 검색을 할 수 있다.
        * 하지만 List를 구현한 인스턴스에서 listIterator 메소드를 호출한 값을 ListIterator 인스턴스에 넘겨야 사용할 수 있다.
        * 일반적으로 타자칠때의 커서 이동과 동일하다고 생각하면된다.
        * 다음 데이터로 이동할 수 있는지는 hasNext()
        * 이전 데이터로 이동할 수 있는지는 hasPrevious()
        * 커서는 삽입된 데이터 오른쪽에 위치해있다고 생각하면 편함
        * 따라서 다음 데이터로 이동이 가능하다면 hasNext로 검사 후 이동하면됨
        * 다음 데이터로의 이동은 next
        * 이전 데이터로의 이동은 previous
        * 그밖의 중요 메서드는 https://godzz.tistory.com/11 참고
         */
        StringBuilder all = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0;i<n;i++){
            String tc = bf.readLine();
            StringBuilder sb = new StringBuilder();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            for(char k : tc.toCharArray()){
                if(k == '-'){
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                }else if(k == '<'){
                    if(iterator.hasPrevious()){
                        iterator.previous();
                    }
                }
                else if(k == '>'){
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                }
                else {
                   iterator.add(k);
                }
            }
            for(char t : list){
                sb.append(t);
            }
            all.append(sb).append("\n");
        }
        System.out.println(all);
    }
}

