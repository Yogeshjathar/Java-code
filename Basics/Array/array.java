
public class array {
    public static void main(String args[]){
        
        // upate array value
        // int marks[] = {97,98,99};
        // updateArray(marks);

        // for(int i=0;i<marks.length;i++){
        //     System.out.println(marks[i]);
        // }

        // liner search
        // int numbers[] = {2,3,23,424,4,565,57,7};
        // int key = 424;

        // int index = linearSearch(numbers,key);
        // if(index == -1){
        //     System.out.println("Not Found ");
        // }
        // else{
        //     System.out.println("Key is at index "+index);
        // }

        // largest value
        int num[] = {1,3,6,7,5};
        System.out.println("largest number in array is : "+largest_smallest_value(num));

    }

    public static void updateArray(int marks[]){

        for(int i=0;i<marks.length;i++){
            marks[i] = marks[i] + 1;
        }
    }
    
    public static int linearSearch(int numbers[],int key){

        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int largest_smallest_value(int number[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0;i<number.length;i++){
            if(largest < number[i]){
                largest = number[i];
            }
            if(smallest > number[i]){
                smallest = number[i];
            }
        }
        System.out.println("smallest number in array is : "+smallest);
        return largest;
    }
}