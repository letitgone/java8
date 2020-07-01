package chapter2;

import chapter1.apple.Apple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author ZhangGJ
 * @Date 2020/06/29 06:47
 */
public class FilteringApples {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new LinkedList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }
}
