import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateElements {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 2, 4, 1);
        getDuplicates(nums);
    }

    public static void getDuplicates(List<Integer> nums){
        HashSet<Integer> seen = new HashSet<>();

        List<Integer> ans = nums.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toList());

        System.out.println(ans);
    }
}
