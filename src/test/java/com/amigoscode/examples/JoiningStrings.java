package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");



        // "Anna, John, Marcos, Helena, Yasmin"
//        StringBuilder sb = new StringBuilder();
//        for (String name : names){
//            String newName = name.substring(0, 1).toUpperCase() + name.substring(1);
//            sb.append(newName);
//            sb.append(", ");
//        }
//        String res = sb.toString();
//        res = res.substring(0,res.length()-2);
//        System.out.println(res);
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        String collect = names.stream()
                .map(str->str.substring(0, 1).toUpperCase() + str.substring(1))
                .collect(Collectors.joining(", "));
        System.out.println(collect);


        // "Anna, John, Marcos, Helena, Yasmin"
//        String collect = names.stream()
//                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
//                .collect(Collectors.joining(", "));
//
//        System.out.println(collect);

    }

}
