import java.util.*;
public class Hashing {
    public static void main(String str[]){
        int arr1[] = {1,2,3,4,45,44};
        int arr2[] = {4,2,3,6,9,44};

        System.out.println("Union is : "+ union(arr1,arr2));
        System.out.println("Intersection is : "+ intersection(arr1,arr2));
    }

    public static int intersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }

        return count;
    }

    public static int union(int arr[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();  // hashset adds only unique value
                                                // means there is no duplicate number in the set 
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        for(int j=0; j<arr2.length; j++){
            set.add(arr2[j]);
        }

        return set.size();
    }
}