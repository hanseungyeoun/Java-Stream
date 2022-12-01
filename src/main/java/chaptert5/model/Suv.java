package chaptert5.model;

public class Suv extends Car {
    public Suv(String name, String brand) {
        super(name, brand);
    }

    @Override
    public void drive() {
        System.out.println("Drive an Suv " + name + " from "+ brand);
    }
}
