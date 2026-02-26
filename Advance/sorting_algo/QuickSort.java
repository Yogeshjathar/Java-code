public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }

    // Time Complexity: O(n log n) on average and O(n^2) in worst case (when the smallest or largest element is always chosen as pivot)
    // logic is to partition the array around a pivot element and then recursively sort the sub-arrays
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // explain this function: it takes the last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    public static int partition(int[] arr, int low, int high) {
        // if we want middle element as pivot
        /* int mid = low + (high - low) / 2;
        swap(arr, mid, high); */

        // if we want random element as pivot
        /* int randomPivotIndex = low + (int)(Math.random() * (high - low + 1));
        swap(arr, randomPivotIndex, high); */
        
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // swap arr[i] and arr[j]
            }
        }

        // After the loop, we need to place the pivot element in its correct position, which is at index i + 1
        swap(arr, i+1, high); // swap arr[i + 1] and arr[high] (or pivot)

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
