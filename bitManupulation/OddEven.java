public class OddEven{
    public static void oddEven(int n){
        if((n & 1)==0){
            System.out.println("Even number");
        }else{
            System.out.println("odd number");
        }
    }
    public static void main(String args[]){
        oddEven(8);
        oddEven(10);
        oddEven(13);
    }
}