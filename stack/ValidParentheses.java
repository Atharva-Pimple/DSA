import java.util.*;

public class ValidParentheses{
    public static boolean valid(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);

            // Opening
            if(curr=='{' || curr=='[' || curr=='('){
                s.push(curr);
            }else{
                if(s.isEmpty()){
                    return false;
                }

                if((s.peek()=='(' && curr==')')
                || (s.peek()=='[' && curr==']')
                || (s.peek()=='{' && curr=='}')){

                    s.pop();
                }
            }
        }

        return s.isEmpty();
    }
    public static void main(String args[]){
        String str="{([{}])}[()]";

        System.out.print(valid(str));
    }
}