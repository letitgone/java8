package chapter7;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author ZhangGJ
 * @Date 2020/07/03 23:13
 */
public class ParallelStreamBenchmark {

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    public static void main(String[] args) {
        System.out.println(parallelSum(100));
        System.out.println(measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");
        System.out.println("Iterative sum done in:" + measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");
        System.out.println("Parallel sum done in: " + measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");
    }
}
