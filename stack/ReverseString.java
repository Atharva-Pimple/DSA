import java.util.Stack;

public class ReverseString{

    public static String reverse(String str){
        Stack<Character> s=new Stack<Character>();
        int idx=0;

        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder res= new StringBuilder("");

        while(!s.isEmpty()){
            res.append(s.pop());
        }

        return res.toString();
    }
    
    public static void main(String args[]){
        String str="HelloWorld";

        System.out.print(reverse(str));

    }
}