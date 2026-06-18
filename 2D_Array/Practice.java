public class Practice {
    
    // public static int searchCount(int[][] matrix, int key){
    //     int count = 0;
    //     for(int i=0; i<matrix.length; i++){
    //         for(int j = 0; j<matrix[0].length; j++){
    //             if(matrix[i][j] == key){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // public static int searchSum(int[][] matrix){
    //     int sum = 0;
    //     int i = 1;
    //     for(int j=0; j<matrix[0].length; j++){
    //         sum += matrix[i][j];
    //     }
    //     return sum;
    // }
    
  public static int[][] transposeMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] transpose = new int[col][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

 public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { {4,7,8},{8,8,7} };
        int[][] transpose = transposeMatrix(matrix);

        System.out.println("Transpose Matrix:");
        printMatrix(transpose);
        // int key = 7;
        // System.out.println(searchCount(matrix, key));
        // int matrix[][] =  {{1,4,9},{11,4,3},{2,2,3} };
        // System.out.println(searchSum(matrix));
    }
}
