package com.amigoscode.openhome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parallelism {
    /*
        Parallelism is a key concept of functional programming where a big task is accomplished by breaking in smaller
        independent tasks and then these small tasks are completed in a parallel fashion and later combined to give the
        complete result. With the advent of multi-core processors, this technique helps in faster code execution.

        Java has Thread based programming support for parallel processing but it is quite tedious to learn and
        difficult to implement without bugs. Java 8 onwards, stream have parallel method and collections has
        parallelStream() method to complete tasks in parallel fashion. See the example below:
     */
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        System.out.println("List using Serial Stream:");
        listOfIntegers.stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("List using Parallel Stream:");
        listOfIntegers
                .parallelStream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("List using Another Parallel Stream:");
        listOfIntegers
                .stream()
                .parallel()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("List using Parallel Stream but Ordered:");
        listOfIntegers
                .parallelStream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}
