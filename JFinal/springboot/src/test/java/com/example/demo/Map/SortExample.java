package com.example.demo.Map;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/28/028 10:57
 * @Version 1.0
 */
public class SortExample {
    @Test
    public void sortByKeyExample() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        System.out.println(unsortMap);

        Map<String, Integer> result1 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oleValue, newValue) -> oleValue, LinkedHashMap::new));
        System.out.println(result1);

        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        System.out.println(result2);
    }

    @Test
    public void soryByKeyExample() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        System.out.println(unsortMap);

        Map<String, Integer> result1 = unsortMap.entrySet().stream()
                //此标明逆序输出
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result1);

        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                //此标明逆序输出
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        System.out.println(result2);
    }

}
