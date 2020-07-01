package chapter5;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2020/07/01 07:24
 */
@Data
public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
