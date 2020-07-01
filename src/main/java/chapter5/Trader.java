package chapter5;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2020/07/01 07:24
 */
@Data
public class Trader {

    private String name;
    private String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
}
