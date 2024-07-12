public class SoretdAndRotated {

    // Solved using recursion 
    public static int search(int arr[],int tar,int si,int ei){
        if(si > ei){
            return -1;
        }
        int mid = si + (ei-si)/2;

        if(arr[mid] == tar){
            return mid;
        }

        // Finding mid wather it lies on l1 or l2
        if(arr[si]<=arr[mid]){ // lies on l1
            // search in left side of mid
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr,tar,si,mid-1);
            }
            // search in right side of mid
            else{
                return search(arr,tar,mid+1,ei);
            }
        }
        else{ // lies on l2
            // search in left side of mid
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr,tar,mid+1,ei);
            }
            // search in right side of mid
            else{
                return search(arr,tar,si,mid-1);
            }
        }
    }

    public static void main(String str[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int indx = search(arr,target,0,arr.length);
        System.out.println(indx);
    }
}