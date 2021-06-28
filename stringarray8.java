import java.io.*;
import java.util.*;
public class stringarray8 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char []cro = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int count=0;
        for(int i=0;i<cro.length;i++){
            stack.push(cro[i]);
        }
        while(!stack.isEmpty()){
            char point = stack.pop();
            if(point=='j'&&!stack.isEmpty()){
                char tmp = stack.pop();
                if(tmp=='n'||tmp=='l'){
                    count++;
                }else{
                   stack.push(tmp);
                   count++;
                }
            }else if(point=='-'){
                char tmp = stack.pop();
                if(tmp=='c'||tmp=='d'){
                    count++;
                }else{
                    stack.push(tmp);
                }
            }else if(point=='='){
                char tmp = stack.pop();
                if(tmp=='c'||tmp=='s'){
                    count++;
                }
                else if(tmp=='z'){
                    if(stack.isEmpty()){
                        count++;
                    }else{
                        char tmp2 = stack.pop();
                        if(tmp2=='d'){
                            count++;
                        }else{
                            stack.push(tmp2);
                            count++;
                        }
                    }
                }else{
                    stack.push(tmp);
                }
            }
            else{
                count++;
            }
        }
        System.out.println(count);
    }
}
