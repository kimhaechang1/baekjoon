import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16987_2 {
    static int N;
    static class Data{
        int du;
        int w;
        public Data(int du, int w){
            this.du = du;
            this.w = w;
        }
    }
    static Data [] datas;
    static StringTokenizer stk;
    static int max;
    public static void main(String[] args) throws Exception {
        // 손에 든 계란이 깨졋거나 깨지지않은 다른 계란이 없으면 치지않고 넘어감
        // 깨지지않은 다른 계란이 없다? -> 자기 자신을 제외하고 모두 깨져있다는 뜻
        // 가장 오른쪽 계란일경우 깨는과정 종료함
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        datas = new Data[N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(bf.readLine());
            datas[i] = new Data(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
        max = Integer.MIN_VALUE;
        dfs(0,0);
        System.out.println(max);

    }
    static void dfs(int depth, int cnt){
        // 현재 들고있는 계란 인덱스, cnt 깨진계란 갯수
        if(depth == N){
            if(max < cnt){
                max = cnt;
            }
            return;
        }
        for(int i= 0;i<N;i++){
            if(datas[depth].du <= 0 || cnt == N-1){
                // 손에들고있는 계란이 깨졌거나 모든 계란을 깻는 경우
                // 옆 계란을 들고 다시시작
                dfs(depth+1, cnt);
                return;
            }
            if(i == depth || datas[i].du <= 0) continue; // 자기자신을 제외하고 또 부딪힐 계란이 깨져있지 않은지 검사
                datas[depth].du-= datas[i].w;
                datas[i].du -= datas[depth].w;
                if(datas[depth].du <=0) cnt++;
                if(datas[i].du <= 0) cnt++;
                dfs(depth+1, cnt);
                if(datas[depth].du <=0) cnt--;
                if(datas[i].du <=0) cnt--;
                datas[depth].du+= datas[i].w;
                datas[i].du+= datas[depth].w;
        }
    }
}
