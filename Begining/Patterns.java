package Begining;

public class Patterns {
    public static void main(String[] args) {
    // Hollow Square pattern 
    //     int rows = 4;
    //     int cols = 5;
    //     for(int i=1;i<=rows;i++){
    //         for(int j=1;j<=cols;j++){
    //             if(i==1 || i==rows || j==1|| j==cols){
    //                 System.out.print("*");
    //             }else{
    //                 System.out.print(" ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    //INVERTED & ROTATED HALF-PYRAMID 
    // int n=5;
    // int count = 1; 
    // for(int i=1; i<=n; i++){
    //     for(int j=1; j<=i; j++){
    //         System.out.print(count+" ");
    //         count++;
    //     }
    //     System.out.println();
    // }

    //0-1 Triangle Pattern

    int n=5;

    for(int i=1; i<=n;i++){
        for(int j=1; j<=i; j++){
            if( (i+j)%2 == 0){
                System.out.print("1");
            }else{
                System.out.print("0");
            }
          
        }
          System.out.println();
    }

    }
}
