package chapter4;

import util.Adder;

import java.util.function.Function;

public class FunctionInterFaceTest {
    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();
        Integer result = myAdder.apply(5);
        System.out.println("result = " + result);

        Function<Integer, Integer> myAdder2 = (Integer x) ->{
            return x + 10;
        };
        Integer result2 = myAdder2.apply(5);
        System.out.println("result2 = " + result2);
        //유추 가능 시 타입 생략
        //인자가 하나일 시 중괄호 생략 
        // 바로 리턴 일 시 리턴문 생략 

        Function<Integer, Integer> myAdder3 = x -> x + 10;
        Integer result3 = myAdder3.apply(5);
        System.out.println("result3 = " + result3);


    }
}
