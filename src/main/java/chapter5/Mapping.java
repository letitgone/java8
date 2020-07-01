package chapter5;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ZhangGJ
 * @Date 2020/06/30 23:46
 */
public class Mapping {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "love", "work");
        System.out.println(list.stream().map(String::length).collect(Collectors.toList()));

        System.out.println(list.stream().map(work -> work.split("")).distinct().collect(Collectors.toList()));

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        System.out.println(num.stream().map(n -> n * n).collect(Collectors.toList()));

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> result = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        result.forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("========");
        List<int[]> pairs = list1.stream().flatMap(i -> list2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        pairs.forEach(a -> System.out.println(Arrays.toString(a)));

        System.out.println(Dish.MENU.stream().map(d -> 1).reduce(0, Integer::sum));
        System.out.println(Dish.MENU.stream().count());
    }
}
