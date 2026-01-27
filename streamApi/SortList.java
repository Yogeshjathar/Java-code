import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 1, 4, 2, 3);
        getAscending(nums);
        getDescending(nums);
    }

    public static void getAscending(List<Integer> nums){

        List<Integer> ans = nums.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Ascending : "+ans);
    }

    public static void getDescending(List<Integer> nums){

        List<Integer> ans = nums.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Descending : "+ans);
    }

    // sort objects then use this
/*
    class Employee {
        String name;
        int salary;
    }
*/

/*
    employees.stream()
         .sorted(Comparator.comparing(Employee::getSalary))
         .collect(Collectors.toList());
*/

}
