import java.io.BufferedReader;
import java.io.InputStreamReader;

public class String1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch =  (char)br.read();
        int ascii = ch;
        System.out.println(ascii);
    }
}
