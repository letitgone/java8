package chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author ZhangGJ
 * @Date 2020/06/29 07:32
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader bufferedReader) throws IOException;

}
