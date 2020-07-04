package chapter8.Observer;

/**
 * @Author ZhangGJ
 * @Date 2020/07/04 09:18
 */
public interface Subject {

    void registerObserver(Observer o);

    void notifyObserver(String tweet);
}
