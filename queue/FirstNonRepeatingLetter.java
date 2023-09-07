import java.util.*;

public class FirstNonRepeatingLetter{
    public static void firstNonRepeating(String str){
        int arr[]=new int[26];
        Queue<Character> q=new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            arr[ch-'a']++;

            while(!q.isEmpty() && arr[q.peek()-'a']>1){
                q.remove();
            }        

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }

    }
    public static void main(String args[]){
        String str="aabccxb";
        firstNonRepeating(str);
    }
}