import java.util.Scanner;

public class Array_2D_Basics {
    public static void main(String args[]){
        int matrix [] [] = new int[3][3];

        take_input(matrix);
        search(matrix,5);
        max_min_Value(matrix);
    }

    public static void take_input(int matrix[][]){
        Scanner sc = new Scanner(System.in);
        int n=3, m=3;

        // input
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // output
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println("Key found at position ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key not found ");
        return false;
    }

    public static void max_min_Value(int matrix[][]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                max = Math.max(max,matrix[i][j]);
                min = Math.min(min,matrix[i][j]);
            }
        }
        System.out.println("Largest value in above array is "+max);
        System.out.println("Smallest value in above array is "+min);
    }
}