public class MaxSubArraySum {
    public static void printSubArray_BruteForce(int[] arr){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                currSum =0;
                for(int k=i; k<=j; k++){
                    currSum += arr[k];
                }
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum of Subarray using Brute Force: "+maxSum);
    }

    public static int printSubArray_Kadanes(int[] arr){
        int cs = 0; // Current sum
        int ms = Integer.MIN_VALUE; // Max sum
        int maxElemet= Integer.MIN_VALUE; // In case if all numbers in array are negative
        for(int i=0; i<arr.length; i++){
            cs += arr[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(ms,cs);
            maxElemet = Math.max(maxElemet,arr[i]);
        }
        return ms == 0 ? maxElemet : ms;
    }

    public static void main(String args[]){
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        printSubArray_BruteForce(arr);
        System.out.println("Maximum sum of Subarray using Kadanes Algorithm: "+ printSubArray_Kadanes(arr));
    }
}