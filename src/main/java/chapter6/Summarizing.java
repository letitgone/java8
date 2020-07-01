package chapter6;

import chapter4.Dish;
import java.util.stream.Collectors;

/**
 * @Author ZhangGJ
 * @Date 2020/07/02 07:33
 */
public class Summarizing {

    public static void main(String[] args) {
        long howManyDishes = Dish.MENU.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);
    }
}
