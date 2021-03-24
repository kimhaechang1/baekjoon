import java.io.*;
import java.util.*;
public class array5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Double[] s = new Double[N];
        String line = br.readLine();
        StringTokenizer stk = new StringTokenizer(line);
        double sum = 0;
        for (int i = 0; i < N; i++) {
            s[i] = Double.parseDouble(stk.nextToken());
        }
        List<Double> l = new ArrayList<>(Arrays.asList(s));
        Collections.sort(l);
        double M = l.get(N - 1);
        for (int i = 0; i < N; i++) {
            l.set(i, (l.get(i) / M) * 100);
        }
        for (Double i : l) {
            sum = sum + i;
        }
        System.out.println(sum / N);
    }
}
