// Longest word with all the prefixes
public class LongestWord{
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    public static Node root=new Node();

    public static void insert(String word){
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }

            curr=curr.children[idx];
        }

        curr.eow=true;
    }

    public static String ans="";

    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i],temp);
                // backtracking
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String args[]){
        String prefixes[]={"a","banana","app","appl","ap","apply","apple"};

        for(int i=0;i<prefixes.length;i++){
            insert(prefixes[i]);
        }

        longestWord(root,new StringBuilder(""));
        System.out.print(ans);

    }
}