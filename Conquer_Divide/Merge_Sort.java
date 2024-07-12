public class Merge_Sort {

    public static void mergesort(int arr[], int si, int ei){

        if(si>=ei){
            return;
        }
        int mid = si + (ei - si) / 2; // finding mid to divide an array into two parts (Left/Right)
        mergesort(arr,si,mid);  // Divide left
        mergesort(arr,mid+1,ei);    // Divide right
        merge(arr,si,mid,ei); // Merge two array
    }

    public static void merge(int arr[], int si,int mid, int ei){
        // left(0,3) = 4 , right(4,6)= 3    =>  6-0+1 = 7
        int temp[] = new int[(ei-si)+1];

        int i = si, j=mid+1, k = 0;     // Iterators for left, right, temp

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){  // remaining element in left portion
            temp[k++] = arr[i++];
        }

        while(j<=ei){   // remaining element in right portion
            temp[k++] = arr[j++];
        }

        for(k=0, i=si;k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void printArray(int arr[]){
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String str[]){
        int arr[] = {2,8,544,5,6,1,4,-22,-2,-4};
        mergesort(arr,0,arr.length-1);
        printArray(arr);
    }

    // Time Complexity - (nlogn)
    // Space Complexity - O(n)
}