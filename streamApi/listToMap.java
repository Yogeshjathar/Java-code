import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class listToMap {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Mango", "Kiwi");

//        convertListToMap1(fruits);
        convertListToMap2(fruits);
    }

    public static void convertListToMap1(List<String> fruits){

        Map<String, Integer> map = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String :: length // fruit -> fruit.length()
                ));

        System.out.println(map);
    }

    public static void convertListToMap2(List<String> fruits){
        Map<String, Integer> map = fruits.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String :: length // fruit -> fruit.length()
                ));

        System.out.println(map);
    }
}
