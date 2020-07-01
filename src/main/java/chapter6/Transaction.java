package chapter6;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2020/07/02 07:01
 */
@Data
public class Transaction {

    private final Currency currency;
    private final double value;

    public Transaction(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }
}
