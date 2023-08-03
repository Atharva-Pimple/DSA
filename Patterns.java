public class Patterns{
    public static void hollowRectangle(int row,int col){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(i==1 || j==1 || i==row || j==col){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void invertedRotatedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void invertedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void foyds_triangle(int n){
        int count=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(count+" ");
                count++;
            }

            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public static void butterfly_pattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();

        }

        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();

        }
    }
    public static void solidRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }   

    public static void diamond(int n){
        // 1st Half
        for(int i=1;i<=n;i++){
            // Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            // Stars
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            // Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }

        // 2nd Half
        for(int i=n;i>=1;i--){
            // Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            // Stars
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            // Spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        // hollowRectangle(5,4);
        // invertedRotatedHalfPyramid(5);
        // invertedHalfPyramid(5);
        // foyds_triangle(5);
        // zero_one_triangle(5);
        // butterfly_pattern(10);
        // solidRhombus(5);
        diamond(3);
    } 
}