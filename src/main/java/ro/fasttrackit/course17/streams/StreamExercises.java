package ro.fasttrackit.course17.streams;

import ro.fasttrackit.course17.homework.ex2.Category;
import ro.fasttrackit.course17.homework.ex2.Clothes;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static ro.fasttrackit.course17.homework.ex2.Category.*;

public class StreamExercises {
    public static void main(String[] args) {
        List<String> names = List.of("Ana", "Maria", "Gheorghe", "Feri");

        List<String> namesWithAtLeast5Chars = names.stream()
                .filter(name -> name.length() >= 5)
                .sorted()
                .toList();

        namesWithAtLeast5Chars.forEach(System.out::println);

        Clothes shirt = new Clothes("T-shirt", 20, NEW);
        Clothes hat = new Clothes("hat", 10, REFURBISHED);
        Clothes jacket = new Clothes("jacket", 57, ON_SALE);
        Clothes shoes1 = new Clothes("shoes", 57, NEW);
        Clothes shoes2 = new Clothes("shoes", 57, NEW);

        List<Clothes> clothes = List.of(shirt, hat, jacket, shoes1, shoes2);

        List<String> newClothesNames = clothes.stream()
//                .filter(item -> item.category() == NEW)
//                .skip(2)
//                .limit(3)
                .map(Clothes::name)
                .distinct()
                .toList();

        Set<String> distinctNames = clothes.stream()
                .map(Clothes::name)
                .collect(toSet());

        newClothesNames.forEach(System.out::println);
        System.out.println("--------------------------------------");
        distinctNames.forEach(System.out::println);
        System.out.println("--------------------------------------");

        Map<String, Integer> nameToPrice = clothes.stream()
                .distinct()
                .collect(Collectors.toMap(Clothes::name, Clothes::price));

//        System.out.println(nameToPrice);
        nameToPrice.entrySet()
                .forEach(System.out::println);
        System.out.println("--------------------------------------");

        Map<Category, List<Clothes>> categoryToClothes = clothes.stream()
                .collect(groupingBy(Clothes::category));

        System.out.println(categoryToClothes);
        System.out.println("--------------------------------------");


        Optional<Clothes> clothesOptional = clothes.stream()
                .filter(item -> item.name().equalsIgnoreCase("jacket"))
                .findFirst();

        Clothes myJacket = clothes.stream()
                .filter(item -> item.name().equalsIgnoreCase("jacket"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No clothing item found"));

        boolean b = clothes.stream()
                .anyMatch(item -> item.category() == REFURBISHED);

        boolean b1 = clothes.stream()
                .allMatch(item -> item.price() > 5);

        int max = clothes.stream()
                .mapToInt(Clothes::price)
                .max()
                .orElseThrow();

        double average = clothes.stream()
                .mapToInt(Clothes::price)
                .average()
                .orElseThrow();

        System.out.println("Max = " + max);
        System.out.println("avg = " + average);


//        Clothes shirt = new Clothes("T-shirt", 20, NEW);
//        Clothes hat = new Clothes("hat", 10, REFURBISHED);
//        Clothes jacket = new Clothes("jacket", 456, ON_SALE);
//        Clothes shoes1 = new Clothes("shoes", 57, NEW);
//        Clothes shoes2 = new Clothes("shoes", 57, NEW);

        List<Clothes> customSortedClothes = clothes.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Clothes::price)
                        .thenComparing(Clothes::name))
                .toList();

        System.out.println(customSortedClothes);
    }
}
