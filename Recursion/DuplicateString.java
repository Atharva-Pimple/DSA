public class DuplicateString{
    public static void removeDuplicate(String str,int indx,StringBuilder newstr,boolean map[]){
        if(str.length()==indx){
            System.out.print(newstr);
            return;
        }

        char curr=str.charAt(indx);
        if(map[curr-'a']){
            removeDuplicate(str,indx+1,newstr,map);
        }else{
            map[curr-'a']=true;
            removeDuplicate(str,indx+1,newstr.append(curr),map);
        }
    }
    public static void main(String args[]){
        String str="atharva";
        removeDuplicate(str,0,new StringBuilder(""),new boolean[26]);
    }
}