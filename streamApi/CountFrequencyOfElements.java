import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfElements {
    public static void main(String[] args) {
        List<String> names = List.of("A", "B", "A", "C", "B", "A");
        countFreq(names);
    }

    public static void countFreq(List<String> names){

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(map);
    }
}
