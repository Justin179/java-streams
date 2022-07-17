package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {
    /*
        map : transfer one data type to another
        here: Person -> PersonDTO
     */
    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        // map -> from one type to another (Person to PersonDTO)
        Function<Person, PersonDTO> dtoFunction = p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge());

        List<PersonDTO> collect = people.stream()
                .filter(p->p.getAge()>25)
                .map(dtoFunction)
                .collect(Collectors.toList());

//        assertThat(people.size()).isEqualTo(collect.size());

        System.out.println(collect);


        // Person in, PersonDTO out
//        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//
//        List<PersonDTO> personDTOS = people.stream()
//                .filter(person -> person.getAge()>20)
//                .map(personPersonDTOFunction)
////                .map(PersonDTO::map) // 直接參考 class內的static method
//                .toList();
////        assertThat(people.size()).isEqualTo(personDTOS.size()); // 程式中的檢查… 沒過，就會斷在這一行
//        personDTOS.forEach(System.out::println);
    }

    // to Double
    // find the average price
    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double average = cars.stream().mapToDouble(Car::getPrice).average().orElse(0.0);
        System.out.println(average);

//        double v = cars.stream()
//                .mapToDouble(Car::getPrice)
//                .average()
//                .orElse(0);
//        System.out.println(v);
    }

    /*
    produce one single result
     */
    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int reduce = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        System.out.println(reduce);


//        int reduce = Arrays.stream(integers).reduce(0, Integer::sum);
//        int reduce2 = Arrays.stream(integers).reduce(0, (a,b)->a-b);
//        System.out.println(reduce);
//        System.out.println(reduce2);

    }
}

