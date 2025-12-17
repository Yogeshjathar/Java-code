public class Transpose_Matrix {
    public static void main(String args[]){
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        print_matrix(matrix);
        transpose(matrix);
      
    }

    public static void print_matrix(int matrix[][]){
        System.out.println("The matrix is : ");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(int matrix[][]){
        int row = matrix.length, col = matrix[0].length;
        
        int transpose_m [][] = new int[col][row];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                transpose_m[j][i] = matrix[i][j];
            }
        }
        print_matrix(transpose_m);
    }
}