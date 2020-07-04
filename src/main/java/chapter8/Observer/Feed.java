package chapter8.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/07/04 09:20
 */
public class Feed implements Subject{

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void notifyObserver(String tweet) {
        observerList.forEach(o -> o.notify(tweet));
    }
}
