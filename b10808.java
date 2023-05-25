import java.io.*;
import java.util.*;
public class b10808 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int [] count = new int[26];
        for(char ch : str.toCharArray()){
            count[ch-97]++;
        }
        for(int i : count) System.out.print(i+" ");
    }
}
//1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
//1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0