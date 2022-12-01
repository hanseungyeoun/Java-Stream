package chapter4;

import java.util.function.BiFunction;

public class BIFunctionPractice {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) ->{
            return x + y;
        };
        int result = add.apply(10, 10);
        System.out.println("result = " + result);


        BiFunction<Integer, Integer, Integer> add2 = (x, y) -> x+y;
        int result2 = add2.apply(10, 10);
        System.out.println("result = " + result2);

    }
}
