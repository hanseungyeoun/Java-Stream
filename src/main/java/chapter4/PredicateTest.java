package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println("isPosivte.test(-10) = " + isPositive.test(-10));


        List<Integer> inputs = Arrays.asList(10, -5, 4, 0);
        System.out.println("Posivtive number " + filter(inputs, isPositive));

        System.out.println("Non-Posivtive number " + filter(inputs, isPositive.negate()));
        System.out.println("Non-negative number " + filter(inputs, isPositive.or(x -> x != 0)));

    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }
}
