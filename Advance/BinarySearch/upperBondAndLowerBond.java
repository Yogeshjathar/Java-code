public class upperBondAndLowerBond {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};
        int target = 1;

        System.out.println("LowerBond :"+getLowerBond(arr, target));
        System.out.println("UpperBond :"+getUpperBond(arr, target));
    }

    // lowerbond -> smallest index such that arr[index] >= target
    public static int getLowerBond(int[] arr, int target){
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    // upperbond -> smallest index such that arr[index] > target
    public static int getUpperBond(int[] arr, int target){
        int n = arr.length;
        int ans = n;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
