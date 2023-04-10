import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b10814 {
    /*
    * 회원의 수 10만이며 숫자의 크기가 1~200으로 매우 적다.
    * 회원을 클래스로 구현하고 필드에 나이와 인덱스를 추가한다.
    * 우선순위 큐에 넣고 정렬 순서를
    * 두 객체의 나이중 더 빠른 나이를 출력하게 만들고
    * 나이가 같다면 인덱스번호가 적은 데이터를 먼저 출력하게 만든다.*/
    static StringTokenizer stk;
    public static void main(String[] args) throws Exception{
        PriorityQueue<Client> q = new PriorityQueue<Client>((o1, o2)->{
           if(o1.age == o2.age){
               return o1.index - o2.index;
           }
           return o1.age - o2.age;
        });
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0;i<n;i++){
            stk  = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(stk.nextToken());
            String name = stk.nextToken();
            q.offer(new Client(i, age, name));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Client o1 = q.poll();
            sb.append(o1.age).append(" ").append(o1.name).append("\n");
        }
        System.out.println(sb);
    }
}

class Client{
    int index;
    int age;
    String name;
    public Client(int index, int age, String name){
        this.index = index;
        this.age = age;
        this.name = name;
    }
}
