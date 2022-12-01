package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        Consumer<String> myStringConsumer = (String str) -> {
            System.out.println("str = " + str);
        };

//        myStringConsumer.accept("hello");
//        myStringConsumer.accept("world");
        List<Integer> integerInputs = Arrays.asList(null);
        Consumer<Integer> myIntegerProcess =  x -> System.out.println("Process  Integer= " + x);
        process(integerInputs, myIntegerProcess);


        Consumer<Integer> myDifferentIntegerProcessor = x ->
                System.out.println("Processing integer in different way " + x);
        process(integerInputs, myDifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x ->
                System.out.println("Processing double " + x);
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        process2(doubleInputs, myDoubleProcessor);
    }


    public static void process(List<Integer> inputs, Consumer<Integer> processor) {
        for (Integer input : inputs) {
            processor.accept(input);
        }
    }

    public static <T> void process2(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

}
