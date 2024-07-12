
public class binary_search {
    public static void main(String arg[]){
        int number[] = {-2,-3,-4,-1,-5,-3};

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter key : ");
        // int key = sc.nextInt();
        // System.out.println("Index of the key is : "+searching(number,key));

        // reverse(number);
        // for(int i=0;i<number.length;i++){
        //     System.out.print(number[i]+" ");
        // }
        // System.out.println();

        // pairs(number);

        // subarrays(number);

        // max_subarrays(number);

        // max_subarrays_prefix(number); // int number[] = {1,-2,6,-1,3};

        max_subarrays_kadane_s(number);     // int number[] = {-2,-3,4,-1,-2,1,5,-3};
    }

    public static int searching(int num[],int key){

        int start = 0, end = num.length -1;
        while(start <= end){
            
            int mid = (start + end)/2;
            if(num[mid] == key){
                return mid;
            }
            if(num[mid] > key){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void reverse(int number[]){
        int first = 0,last = number.length-1;

        while(first<last){
            // swap
            int tmp = number[first];
            number[first] = number[last];
            number[last] = tmp;

            first++;
            last--;
        }
    }

    public static void pairs(int numbers[]){
        int tp= 0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+numbers[i]+","+numbers[j]+")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("tp = "+tp);
    }

    public static void subarrays(int numbers[]){
        int ts=0;
        for(int i=0; i<numbers.length; i++){    // int start = i;
            for(int j=i;j<numbers.length;j++){  // int end = j;
                for(int k=i;k<=j;k++){          // k = start to end ;
                    System.out.print(numbers[k]+" ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays : "+ts);
    }

    public static void max_subarrays(int numbers[]){
        // brute force
        // number[] = {2,4,6,8,10}
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){

            for(int j=i;j<numbers.length;j++){
                curr_sum = 0;
                for(int k=i;k<=j;k++){
                    curr_sum += numbers[k];
                }
                System.out.println(curr_sum);
                if(max_sum < curr_sum){
                    max_sum = curr_sum;
                }
            }
            System.out.println();
        }
        System.out.println("maximum sum of subarrays : "+max_sum);
    }

    public static void max_subarrays_prefix(int numbers[]){
        // number[] = {1,-2,6,-1,3}
        int curr_sum = 0;   
        int max_sum = Integer.MIN_VALUE;

        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1] + numbers[i];
        }

        for(int i=0;i<numbers.length;i++){
            int start= i;
            for(int j=i;j<numbers.length;j++){
                int end = j;
                curr_sum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if(max_sum < curr_sum){
                    max_sum = curr_sum;
                }
            }
        }
        System.out.println("maximum sum of subarrays : "+max_sum);
    }

    public static void max_subarrays_kadane_s(int numbers[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;

        for(int i=0;i<numbers.length;i++){
            cs = cs + numbers[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("maximum sum of subarrays : " + ms);
    }
}