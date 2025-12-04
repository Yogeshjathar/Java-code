public class MaxSubArraySum {
    public static void printSubArray_BruteForce(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int currSum = 0;
            for(int j=i; j<arr.length; j++){
                currSum += arr[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Maximum sum of Subarray using Brute Force: "+maxSum);
    }

    public static int printSubArray_Prefixsum(int arr[]){
        int n = arr.length;
        int ms = Integer.MIN_VALUE;
        int prefix[] = new int[n];

        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int curr_sum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                ms = Math.max(curr_sum, ms);
            }
        }
        return ms;
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

    // both are same but boilerplate code is reduced
    public static int maxSubArray_Kadanes(int[] nums) {
        int cs = nums[0];
        int ms = nums[0];

        for(int i=1; i<nums.length; i++){
            cs = Math.max(nums[i], cs + nums[i]);
            ms = Math.max(cs, ms);
        }

        return ms;
    }

    public static void main(String args[]){
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        printSubArray_BruteForce(arr);
        System.out.println("Maximum sum of Subarray using Kadanes Algorithm: "+ printSubArray_Kadanes(arr));
    }
}
