public class reverseArray {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        reverse(arr);
    }

    public static void reverse(int arr[]){
        // int revArr[] = new int[arr.length];

        // for(int i=0; i<arr.length; i++){
        //     revArr[i] = arr[arr.length-i-1];
        // }
        
        // for(int i=0; i<revArr.length; i++){
        //     System.out.print(revArr[i] + " ");
        // }
        // System.out.println();

        int lp = 0;
        int rp = arr.length-1;

        while(lp<rp){
            int temp = arr[lp];
            arr[lp] = arr[rp];
            arr[rp] = temp;
            lp++;
            rp--;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}