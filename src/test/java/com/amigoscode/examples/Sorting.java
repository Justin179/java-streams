package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> strings = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .toList();
        strings.forEach(System.out::println);


//        List<String> list = people.stream()
//                .map(Person::getFirstName)
//                .sorted()
//                .collect(Collectors.toList());
//        list.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();


        Comparator<String> comparator = Comparator.reverseOrder();
        List<String> strings = people.stream()
                .map(Person::getFirstName)
                .sorted(comparator)
                .toList();
        strings.forEach(System.out::println);



//        List<String> list = people.stream()
//                .map(Person::getFirstName)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//        list.forEach(System.out::println);

    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator
                .comparing(Person::getEmail)
                .reversed();

        List<Person> list = people.stream()
                .sorted(comparing)
                .toList();
        list.forEach(System.out::println);


//        Comparator<Person> comparing = Comparator
//                .comparing(Person::getFirstName)
//                .thenComparing(Person::getAge)
//                .reversed();
//
//        List<Person> list = people.stream()
//                .sorted(comparing)
//                .collect(Collectors.toList());
//        list.forEach(System.out::println);

    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> carList = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .toList();
        carList.forEach(System.out::println);


//        List<Car> carList = cars.stream()
//                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
//                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
//                .limit(10)
//                .collect(Collectors.toList());
//        carList.forEach(System.out::println);
    }

}




















