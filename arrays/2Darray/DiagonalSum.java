public class DiagonalSum{
    public static int sum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==j){
                    sum += arr[i][j];
                }else if(i+j == arr.length-1){
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    public static int optimizedSum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i][i];
            if(i != arr.length-1-i){
                sum += arr[i][arr.length-1-i];
            }
            
        }

        return sum;
    }

    public static void main(String args[]){
        // int matrix[][]={{1,2,3,4},
        //                 {5,6,7,8},
        //                 {9,10,11,12},
        //                 {13,14,15,16}};

        int matrix[][]={{1,2,3},
                        {4,5,6,},
                        {7,8,9}};

        // System.out.print(sum(matrix));
        System.out.print(optimizedSum(matrix));

    }
}