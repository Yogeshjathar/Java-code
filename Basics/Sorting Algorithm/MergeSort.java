public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {4,21,3,5,1,6};
        ms(arr, 0, arr.length-1);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static void ms(int[] arr, int low, int high){
        // Base case
        if(low >= high) return;
        int mid = (low + high) / 2;

        ms(arr, low, mid);
        ms(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i = 0;

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[i++] = arr[left++];
            }else{
                temp[i++] = arr[right++];
            }
        }

        while(left <= mid){
            temp[i++] = arr[left++];
        }

        while(right <= high){
            temp[i++] = arr[right++];
        }

        for(int j=low; j<=high; j++){
            arr[j] = temp[j - low];
        }
    }
}
