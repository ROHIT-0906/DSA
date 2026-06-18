
import java.util.Scanner;


public class twoDArray {

    public static void search(int matrix[][]){
         int smallest = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
           
            for(int j=0; j<matrix[0].length; j++){
                smallest = Math.min(smallest, matrix[i][j]);
                
            }
        }
      System.out.println("Smallest element:" +smallest);
    }

    public static void main(String[] arg){
        int matrix[][] = new int[3][3];
        int n = 3; 
        int m=3;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        

        for(int i=0; i<n; i++){
            for(int j=0; j<1; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix);
    }
}
