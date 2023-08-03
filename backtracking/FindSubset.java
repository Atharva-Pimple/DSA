public class FindSubset{
    public static void subset(String str,int i,String ans){
        if(str.length()==i){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }

            return;
        }
        // Choice yes
        subset(str,i+1,ans+str.charAt(i));

        // Choice no
        subset(str,i+1,ans);
    }
    public static void main(String args[]){
        String str="abc";
        subset(str,0,"");
    }
}