package chaptert5.model;

public class Van extends Car{
    public Van(String name, String brand) {
        super(name, brand);
    }

    @Override
    public void drive() {
        System.out.println("Drive an Van " + name + " from "+ brand);
    }
}
