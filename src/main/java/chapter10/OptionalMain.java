package chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author ZhangGJ
 * @Date 2020/07/05 17:20
 */
public class OptionalMain {

    public static void main(String[] args) {

        Map<String, Object> map =  new HashMap<>();
        Object value = map.get("key");
        System.out.println(value);

        Optional<Object> value1 = Optional.ofNullable(map.get("key"));
        System.out.println(value1);
    }
}
