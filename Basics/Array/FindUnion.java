import java.util.*;

public class FindUnion {

    public static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // List to store union elements
        List<Integer> union = new ArrayList<>();
        
        int i = 0; 
        int j = 0;
        
        while(i < n && j < m){
            if(arr1[i] == arr2[j]){
                addIfNotDuplcate(union, arr1[i++]);
                j++;
            }else if(arr1[i] < arr2[j]){
                addIfNotDuplcate(union, arr1[i++]);
            } else{
                addIfNotDuplcate(union, arr2[j++]);
            }
        }
        
        while(i < n){
            addIfNotDuplcate(union, arr1[i++]);
        }
        
        while(j < m){
            addIfNotDuplcate(union, arr2[j++]);
        }
        
        // Return the union list
        return union;
    }

    public static void addIfNotDuplcate(List<Integer> union, int val){
        if(union.isEmpty() || union.get(union.size() - 1) != val){
            union.add(val);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length, m = arr2.length;

        List<Integer> result = findUnion(arr1, arr2, n, m);

        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result) System.out.print(val + " ");
    }
}
