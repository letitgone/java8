package chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static chapter4.Dish.MENU;

/**
 * @Author ZhangGJ
 * @Date 2020/06/30 08:05
 */
public class StreamBasic {

    List<String> lowCaloricDishesName = MENU.stream().filter(dish -> dish.getCalories() < 400)
            .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
            .collect(Collectors.toList());

    List<String> lowCaloricDishesName2 =
            MENU.parallelStream().filter(dish -> dish.getCalories() < 400)
                    .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
                    .collect(Collectors.toList());

    List<String> threeHighCaloricDishName =
            MENU.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3)
                    .collect(Collectors.toList());
}
