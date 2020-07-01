package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author ZhangGJ
 * @Date 2020/07/01 07:25
 */
public class PuttingIntoPractice {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions =
                Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
                        new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
                        new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        List<Transaction> list1 =
                transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                        .sorted(Comparator.comparing(Transaction::getValue))
                        .collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 =
                transactions.stream().map(transaction -> transaction.getTrader().getCity())
                        .distinct().collect(Collectors.toList());
        System.out.println(list2);

        List<Trader> list3 = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity())).distinct()
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(list3);

        String list4 =
                transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct()
                        .sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(list4);

        Boolean list5 = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(list5);

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue).forEach(System.out::println);

        Optional<Integer> list7 =
                transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(list7);

        Optional<Transaction> list8 = transactions.stream().reduce((transaction1, transaction2) ->
                transaction1.getValue() > transaction2.getValue() ?
                        transaction2 :
                        transaction1);
        System.out.println(list8);

        Optional<Transaction> list81 =
                transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(list81);
    }
}
