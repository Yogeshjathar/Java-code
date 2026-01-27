import java.util.Comparator;
import java.util.List;

public class FindSecondHighestNum {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 5, 20, 8);
        getSecondHighest(nums);
    }

    private static void getSecondHighest(List<Integer> nums) {

        int secondHighest =  nums.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                        .get();

        System.out.println("Second Highest Number : "+secondHighest);
    }
}
