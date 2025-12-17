public class Quick_Sort {

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pidx = partition(arr,si,ei);
        quickSort(arr,si,pidx-1);
        quickSort(arr,pidx+1,ei);
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;
        return i;
    }

    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ ",");
        }
        System.out.println();
    }

    public static void main(String strs[]){
        int arr[] = {6,4,2,8,-22,4,9,3};
        quickSort(arr,0,arr.length-1);
        printarr(arr);
    }

    // Time Complexity -  averge - O(nlogn)
    //                    worst - 0(n^2)
    // Space Complexity - O(1)
}