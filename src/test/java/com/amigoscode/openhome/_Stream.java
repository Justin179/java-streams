package com.amigoscode.openhome;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
JDK8引入了Stream API，也引入了管線操作風格，一個管線基本上包括了幾個部份：

來源（Source）：可能是檔案、陣列、群集（Collection）、產生器（Generator）等，在這個例子就是指定的檔案。

零或多個中介操作（Intermediate operation）：又稱為聚合操作（Aggregate operation），
這些操作呼叫時，並不會立即進行手邊的資料處理，它們很懶惰（Lazy），
只會在後續中介操作要求資料時才會動手處理下一筆資料，像是第二個程式片段中的filter()方法。

一個最終操作（Terminal operation）：最後真正需要結果的操作，這個操作會要求之前懶惰的中介操作開始動手。

這就是Stream API之所以命名為Stream的原因，Stream實例銜接了來源，提到中介操作方法，每個中介操作方法都會傳回Stream實例，但不會實際進行資料處理，
每個中介操作後的Stream實例會串連在一起，Stream亦提供最終操作方法，不是傳回Stream而是傳回真正需要的結果，
最終操作方法會引發之前串連在一起的Stream實例進行資料處理。

 */
public class _Stream {

    public static void main(String[] args) throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> list = people.stream()
                .filter(p -> p.getAge() > 15)
                .map(p -> p.getFirstName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println(list);

        int sum = people.stream()
                .filter(person -> Objects.equals(person.getGender(), "Male"))
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);

        int average = (int) people.stream()
                .filter(person -> Objects.equals(person.getGender(), "Male"))
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(average);

        int max = people.stream()
                .filter(person -> Objects.equals(person.getGender(), "Male"))
                .mapToInt(Person::getAge)
                .max()
                .getAsInt();
        System.out.println(max);
    }



}
