package chapter4;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> myStringSupplier = () -> "hello word!";
        System.out.println("myStringSupplier.get() = " + myStringSupplier.get());

        Supplier<Double> myRandomDoubelSupplier = () -> Math.random();
        printRandomDoubles(myRandomDoubelSupplier, 5);

    }

    public static void printRandomDoubles(Supplier<Double> rendomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(rendomSupplier.get());
        }
    }
}
