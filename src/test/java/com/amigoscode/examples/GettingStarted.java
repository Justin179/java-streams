package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> list = new ArrayList<>();
        for (Person person : people){
            if (person.getAge()<=18){
                list.add(person);
                if (list.size()==10)
                    break;
            }
        }
//        System.out.println(list);
        list.forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> collect = people.stream().filter(p -> p.getAge() <= 18).limit(10).collect(Collectors.toList());
        System.out.println("declarative: ");
        collect.forEach(System.out::println);
    }
}
