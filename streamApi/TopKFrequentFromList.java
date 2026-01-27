import java.util.*;
import java.util.stream.Collectors;


public class TopKFrequentFromList {

    public static void main(String[] args) {
        List<Integer> names = Arrays.asList(1,1,1,2,2,3,3,3);
        int k = 2;

        List<Integer> result = names.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>
                        comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();

        for(int i : result){
            System.out.println(i+" ");
        }
    }
}
