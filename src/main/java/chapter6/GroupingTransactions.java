package chapter6;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author ZhangGJ
 * @Date 2020/07/02 06:59
 */
public class GroupingTransactions {

    public static List<Transaction> transactions =
            Arrays.asList(new Transaction(Currency.EUR, 1500.0),
                    new Transaction(Currency.USD, 2300.0), new Transaction(Currency.GBP, 9900.0),
                    new Transaction(Currency.EUR, 1100.0), new Transaction(Currency.JPY, 7800.0),
                    new Transaction(Currency.CHF, 6700.0), new Transaction(Currency.EUR, 5600.0),
                    new Transaction(Currency.USD, 4500.0), new Transaction(Currency.CHF, 3400.0),
                    new Transaction(Currency.GBP, 3200.0), new Transaction(Currency.USD, 4600.0),
                    new Transaction(Currency.JPY, 5700.0), new Transaction(Currency.EUR, 6800.0));

    public static void main(String... args) {
        groupImperatively();
        groupFunctionally();
    }

    private static void groupImperatively() {
        Map<Currency, List<Transaction>> transactionByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));
        System.out.println(transactionByCurrencies);
    }

    private static void groupFunctionally() {
        Map<Currency, List<Transaction>> result = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> value = result.get(currency);
            if (value == null) {
                value = new LinkedList<>();
                result.put(currency, value);
            }
            value.add(transaction);
        }
    }

}
