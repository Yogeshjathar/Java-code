public class QuickSort {
    public static void main(String[] args){
        int arr[] = {3,4,2,1,9,7,5};
        qs(arr, 0, arr.length-1);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n) -> auxiliary stack space.
    public static void qs(int[] arr, int low, int high){
        if(low < high){
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex-1);
            qs(arr, pIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i < high){
                i++;
            }

            while(arr[j] > pivot && j > low){
                j--;
            }

            if(i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
