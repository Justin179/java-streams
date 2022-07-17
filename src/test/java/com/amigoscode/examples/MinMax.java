package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer integer = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(integer);


//        Integer integer = numbers.stream().min(Comparator.naturalOrder()).get();
//        System.out.println(integer);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer integer = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(integer);

//        Integer integer = numbers.stream().max(Comparator.naturalOrder()).get();
//        System.out.println(integer);
    }
}









