package com.amigoscode.optional;

import java.util.Arrays;
import java.util.Optional;
/*
purpose of Optional
    avoid null pointer exception & unnecessary null checks

 */
public class Main {
    // without Optional
    public Integer findElement(Integer[] arr, int x){
        for (Integer num : arr){
            if (num==x){
                return x;
            }
        }
        return null;
    }
    public static Optional<Integer> findElementOptional(Integer[] arr, int x){
        return Arrays.stream(arr).filter(integer -> integer==x).findFirst();
//        for (Integer num : arr){
//            if (num==x){
//                return Optional.of(x);
//            }
//        }
//        return Optional.empty();
    }


    public static void main(String[] args) {
        // Optional
        // container object
        // item or empty

        Optional<Integer> integer = Optional.of(5);
        Optional<Integer> empty = Optional.empty();

//        System.out.println(integer.isPresent());
//        System.out.println(empty.isPresent());

//        integer.ifPresent(System.out::println);
//        empty.ifPresent(System.out::println);

        findElementOptional(new Integer[]{1,2,3,4,5},3).ifPresent(System.out::println);
        findElementOptional(new Integer[]{1,2,3,4,5},7).ifPresent(System.out::println);
    }
}
