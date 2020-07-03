package chapter6;

import chapter4.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author ZhangGJ
 * @Date 2020/07/03 07:07
 */
public class Partitioning {

    public static void main(String[] args) {

        Map<Boolean, List<Dish>> partitionedMenu =
                Dish.MENU.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);

        List<Dish> vegetarianDishes2 =
                Dish.MENU.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianDishes2);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.MENU.stream()
                .collect(Collectors
                        .partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.MENU.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }
}
