package chapter6;

import chapter4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @Author ZhangGJ
 * @Date 2020/07/02 07:33
 */
public class Summarizing {

    public static void main(String[] args) {
        long howManyDishes = Dish.MENU.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);

        long howManyDishes2 = Dish.MENU.stream().count();
        System.out.println(howManyDishes2);

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = Dish.MENU.stream().collect(maxBy(dishCaloriesComparator));

        int totalCalories = Dish.MENU.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double avgCalories = Dish.MENU.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics menuStatistics = Dish.MENU.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = Dish.MENU.stream().map(Dish::getName).collect(joining());
//        String shortMenu2 = (String) Dish.MENU.stream().collect(joining());
        System.out.println(shortMenu);
        String shortMenu3 = Dish.MENU.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu3);

    }
}
