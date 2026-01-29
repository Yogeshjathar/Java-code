public class LongestSubArrSumWithSumK {
    
    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int maxLen1 = longestSubarray1(nums1, k);
        // Output the result
        System.out.println("The length of longest subarray having sum k is: " + maxLen1);

        int[] nums2 = {-1, 1, 1};
        int k2 = 1;
        int maxLen2 = longestSubarray2(nums2, k2);

        System.out.println("The length of longest subarray having sum k is: " + maxLen2);
    }

    // for positive numbers
    private static int longestSubarray1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while(right < nums.length){
            sum += nums[right];

            while(sum > k){
                sum -= nums[left++];
            }

            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;
        }

        return maxLen;
    }

    // for positive and negative numbers
    private static int longestSubarray2(int[] nums, int k) {
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];

                if(sum == k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
}
