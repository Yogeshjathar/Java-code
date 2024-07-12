import java.util.*;

public class SearchInSortedMatrix {
    public static void main(String args[]){
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Key for searching : ");
        int key = sc.nextInt(); // key = 33
        // stairCaseSearch_TopRightCell(matrix,key);
        stairCaseSearch_BottomLeftCell(matrix,key);

    }

    public static boolean stairCaseSearch_TopRightCell(int matrix[][],int key){
        int row = 0, col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.println("Key found at position (" +row+ ","+col+ ")");
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }

        System.out.println("Key not found");
        return false;
    }

    public static boolean stairCaseSearch_BottomLeftCell(int matrix[][],int key){
        int row = matrix.length-1, col = 0;

        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] == key){
                System.out.println("Key found at position (" +row+ ","+col+ ")");
                return true;
            }
            else if(key > matrix[row][col]){
                col++;
            }
            else{
                row--;
            }
        }

        System.out.println("Key not found");
        return false;
    }
}