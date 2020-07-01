package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ZhangGJ
 * @Date 2020/06/29 07:24
 */
public class ExecuteAround {

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(bufferedReader);
        }
    }

    public static void main(String[] args) throws IOException {
        String result = processFile(
                (BufferedReader bufferedReader) -> bufferedReader.readLine() + bufferedReader
                        .readLine());

        Runnable runnable = () -> {
            System.out.println("123");
        };
    }
}
