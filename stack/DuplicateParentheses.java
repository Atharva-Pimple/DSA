import java.util.*;

public class DuplicateParentheses{
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(curr==')'){
                int count=0;
                while(s.pop() != '('){
                    count++;
                }

                if(count < 1){
                    return true;
                }
            }else{
                s.push(curr);
            }
        } 

        return false;

    }
    public static void main(String args[]){
        String str="((a+b))";//true
        String strr="((a+b)-(a-b))";//false

        System.out.println(isDuplicate(str));
        System.out.print(isDuplicate(strr));
    }
}