
import java.util.*;

public class AbsoluteDifference {
    public static void main(String[] args) {// Time Complexity - O(nlogn)
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        // Sorting - O(logn)
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i=0; i<A.length; i++){ // O(n)
            minDiff += Math.abs(A[i]-B[i]);
        }
        System.out.println("Min absolute difference pairs : "+minDiff);
    }
}
