package com.JavaConcepts.streamApi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        Map<Boolean, List<Integer>> evenOdd = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
                // .collect(Collectors.groupingBy(n -> n % 2 == 0));

        System.out.println(evenOdd);
    }
}
