package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String word : x)
                if (!Character.isUpperCase(word.charAt(0)))
                    return false;
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> values = new ArrayList<>();
        return x -> {
            x.forEach(v -> {if (v%2==0) values.add(v);});
            x.addAll(values);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return  () -> values.stream()
                .filter(v -> Character.isUpperCase(v.charAt(0)))
                .filter(v -> v.endsWith("."))
                .filter(v -> v.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return  x -> {
            Map<String, Integer> result = new LinkedHashMap<>();
            x.forEach(string -> result.put(string, string.length()));
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            ArrayList<Integer> arrList = new ArrayList<>();
            arrList.addAll(list1);
            arrList.addAll(list2);
            return arrList;
        };
    }
}
