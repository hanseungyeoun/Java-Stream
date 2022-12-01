package chaptert5;

import chaptert5.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ConstructorReference {
    public static void main(String[] args) {
        User user = new User(1, "Alice");
        BiFunction<Integer, String, User> userCreator = User::new;
        User charlie = userCreator.apply(3, "charlie");
        System.out.println("charlie = " + charlie);

        Map<String, BiFunction<String, String, Car>> carTypToConstructorMap = new HashMap<>();
        carTypToConstructorMap.put("sedan", Sedan::new);
        carTypToConstructorMap.put("van", Van::new);
        carTypToConstructorMap.put("suv", Suv::new);


        String[][] inputs = new String[][] {
                { "sedan", "Sonata", "Hyundai" },
                { "van", "Sienna", "Toyota" },
                { "sedan", "Model S", "Tesla" },
                { "suv", "Sorento", "KIA" }
        };

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypToConstructorMap.get(carType).apply(name, brand));
        }

        for (Car car : cars) {
            car.drive();
        }

    }
    

}
