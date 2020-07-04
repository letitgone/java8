package chapter8.Observer.impl;

import chapter8.Observer.Observer;

/**
 * @Author ZhangGJ
 * @Date 2020/07/04 08:40
 */
public class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in Londa..." + tweet);
        }
    }
}
