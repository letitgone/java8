package chapter1.apple;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2020/06/22 08:02
 */
@Data
public class Apple {

    private Integer weight;

    private String color;

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }
}
