import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b13300 {
    static String [] buffer;
    public static void main(String[] args) throws Exception{
        // 0 : 여, 1 : 남
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        buffer = bf.readLine().split(" ");
        int n = Integer.parseInt(buffer[0]);
        int k = Integer.parseInt(buffer[1]);
        int count = 0;
        int [][] stu = new int[7][2];
        for(int i= 0;i<n;i++){
            buffer = bf.readLine().split(" ");
            int grade= Integer.parseInt(buffer[1]);
            int s= Integer.parseInt(buffer[0]);
            stu[grade][s]++;
        }

        for(int i=1;i<=6;i++){
            if(stu[i][0] == 0 && stu[i][1] == 0) continue;
            if(stu[i][1] != 0 && stu[i][1] % k == 0){
                count +=stu[i][1]/k;
            }else if(stu[i][1] != 0 && stu[i][1] %k !=0 ){
                count+=stu[i][1]/k;
                count+=1;
            }
            if(stu[i][0] != 0 && stu[i][0] % k == 0){
                count +=stu[i][0]/k;
            }else if(stu[i][0] != 0 && stu[i][0] %k !=0 ){
                count+=stu[i][0]/k;
                count+=1;
            }
        }
        System.out.println(count);
    }
}
