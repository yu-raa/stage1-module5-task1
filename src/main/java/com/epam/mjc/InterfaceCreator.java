package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (!Character.isAlphabetic(str.charAt(0)) || str.charAt(0) != str.toUpperCase().charAt(0)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            return values.stream().filter(str ->
                    (str.charAt(0) == str.toUpperCase().charAt(0) && str.endsWith(".") && str.split(" ").length >= 4)).collect(Collectors.toList());
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> stringIntegerMap = new TreeMap<>();
            for (String str : list) {
                stringIntegerMap.put(str, str.length());
            }

            return stringIntegerMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
