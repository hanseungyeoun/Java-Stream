package chapter9;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CurryPractice {
    public static void main(String[] args) {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;

        Function<Integer, Integer> addTree = curriedAdd.apply(3);
        int result = addTree.apply(10);
        System.out.println("result = " + result);


    }

    public static Supplier<String> getStringSupplier(){
        String hello = "Hello";
        Supplier<String> supplier = () -> {
            String world = "World";
            return hello + world;
        };

        return supplier;
    }
}
