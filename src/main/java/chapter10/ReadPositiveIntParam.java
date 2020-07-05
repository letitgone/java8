package chapter10;

import java.util.Properties;

/**
 * @Author ZhangGJ
 * @Date 2020/07/05 17:28
 */
public class ReadPositiveIntParam {

    public int readDurationImperative(Properties properties, String name) {
        String value = properties.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
            }
        }
        return 0;
    }
}
