package recursion;

import java.util.Stack;

public class SubSequenseWithSumK {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int k = 2;
        Stack<Integer> s = new Stack<>();
        // printAllSubsequences(0, s, 0, k, arr, arr.length);
        // printOneSubsequences(0, s, 0, k, arr, arr.length);
        System.out.println(printCountOfSubsequences(0,  0, k, arr, arr.length));
    
    }

    /*  Each element has two choices, so the time complexity is O(2ⁿ).
        The space complexity is O(n) due to recursion stack depth */
        
    // Time complexity : O(2^n * n)
    // Space complexity : O(n)
    private static void printAllSubsequences(int index, Stack<Integer> stack, int sum, int k, int[] arr, int n) {
        // Optimization
        // for positive elements only
        if(sum > k) return;

        // Base case
        if(index == n){
            if(sum == k){
                for(int s : stack){
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            return;
        }

        // pick element 
        stack.push(arr[index]);
        sum += arr[index];
        printAllSubsequences(index+1, stack, sum, k, arr, n);

        stack.pop();
        sum -= arr[index];
        // Don't pick element 
        printAllSubsequences(index+1, stack, sum, k, arr, n);
    }

    // Time complexity : O(2^n)
    // Space complexity : O(n)  -> stack + recursion depth
    private static boolean printOneSubsequences(int index, Stack<Integer> stack, int sum, int k, int[] arr, int n) {
        // Optimization
        // for positive elements only
        if(sum > k) return false;
        
        // Base case
        if(index == n){
            if(sum == k){
                for(int s : stack){
                    System.out.print(s + " ");
                }
                System.out.println();
                return true;
            }else{
                return false;
            }
        }

        // pick element 
        stack.push(arr[index]);
        sum += arr[index];
        if(printOneSubsequences(index+1, stack, sum, k, arr, n) == true){
            return true;
        }

        stack.pop();
        sum -= arr[index];
        // Don't pick element 
        if(printOneSubsequences(index+1, stack, sum, k, arr, n) == true){
            return true;
        }

        return false;
    }

    // Time complexity : O(2^n)
    // Space complexity : O(1)  -> recursion depth
    private static int  printCountOfSubsequences(int index, int sum, int k, int[] arr, int n) {
        // Optimization
        // for positive elements only
        if(sum > k) return 0;
        
        // Base case
        if(index == n){
            if(sum == k){
                return 1;
            }else{
                return 0;
            }
        }

        // pick element 
        sum += arr[index];
        int l = printCountOfSubsequences(index+1, sum, k, arr, n);

        sum -= arr[index];
        // Don't pick element 
        int r = printCountOfSubsequences(index+1, sum, k, arr, n);

        return l + r;
    }
}
