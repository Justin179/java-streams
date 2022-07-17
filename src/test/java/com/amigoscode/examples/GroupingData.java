package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();

        Map<String, List<Car>> map = cars.stream()
                .collect(Collectors.groupingBy(car -> car.getMake()));
        map.forEach((name,list) -> {
            System.out.println(name);
            list.forEach(c-> System.out.println(c));
            System.out.println("---------------");
        });


//        Map<String, List<Car>> map = cars.stream()
//                .collect(Collectors.groupingBy(Car::getMake));
////        System.out.println(collect);
//        map.forEach((s,list)->{
//            System.out.println("make: " + s);
//            list.forEach(System.out::println);
//        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

//        Map<String, Long> map = names.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map);

    }

}