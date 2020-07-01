package chapter3;

import chapter1.apple.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/06/29 23:49
 */
public class Sorting {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays
                .asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"), new Apple(2, "red")));

        inventory.sort(new AppleComparator());

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(Comparator.comparing(a -> a.getWeight()));

        inventory.sort(Comparator.comparing(Apple::getWeight));

    }
}

class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
