package chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author ZhangGJ
 * @Date 2020/07/01 23:41
 */
public class BuildingStreams {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::print);
        System.out.println();

        int[] number = {2, 3, 4, 5};
        int sum = Arrays.stream(number).sum();
        System.out.println(sum);

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(uniqueWords);
        } catch (IOException e) {

        }

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println();

        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10)
                .map(t -> t[0]).forEach(System.out::println);

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }

    public static int fibonacci(int i) {
        if (i <= 2) {
            return 1;
        }
        return fibonacci(i - 2) + fibonacci(i - 1);
    }
}
