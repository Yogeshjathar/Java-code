import java.util.List;

public class FindMaxMin {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 10, 11, 11, 12, 2, 4, 1);
        getMax(nums);
        getMin(nums);
    }

    public static void getMax(List<Integer> nums){

        int max = nums.stream()
                .max(Integer::compareTo)
                .get();

        System.out.println("MAX : "+max);
    }

    public static void getMin(List<Integer> nums){

        int max = nums.stream()
                .min(Integer::compareTo)
                .get();

        System.out.println("MIN : "+max);
    }
}
