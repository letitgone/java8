package chapter8.Observer;

import chapter8.Observer.impl.Guardian;
import chapter8.Observer.impl.LeMonde;
import chapter8.Observer.impl.NYTimes;

/**
 * @Author ZhangGJ
 * @Date 2020/07/04 09:22
 */
public class Test {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObserver("123");
    }
}
