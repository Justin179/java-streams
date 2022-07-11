package com.amigoscode.openhome;

import java.util.function.Function;
/*
    High Order Function
        A high order function either takes a function as a parameter or returns a function.
        In Java, we can pass or return a lambda expression to achieve such functionality.
 */
public class FunctionTester {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        Function<Integer, Integer> square = t -> t * t;
        Function<Integer, Integer> cube = t -> t * t * t;

        for(int i = 0; i < array.length; i++){
            print(square, array[i]);
        }
//        for(int i = 0; i < array.length; i++){
//            print(cube, array[i]);
//        }
    }

    private static <T, R> void print(Function<T, R> function, T t ) {
        System.out.println(function.apply(t));
    }
}
