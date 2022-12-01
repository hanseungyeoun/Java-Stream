package chapter6;

import chapter6.model.Order;
import chapter6.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chapter6.model.OrderLine.*;
import static chapter6.model.OrderLine.OrderLineType.*;

public class FlatMapPractice {
    public static void main(String[] args) {
        String[][] cities = new String[][]{
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "Barcelona"}
        };
        Stream<String[]> citiesStram = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamStream = citiesStram.map(x -> Arrays.stream(x));
        List<Stream<String>> collect = cityStreamStream.collect(Collectors.toList());

        Stream<String[]> citiesStram2 = Arrays.stream(cities);
        Stream<String> stringStream = citiesStram2.flatMap(x -> Arrays.stream(x));
        List<String> stringList = stringStream.collect(Collectors.toList());
        System.out.println("stringList = " + stringList);

        Stream<String[]> citiesStram3 = Arrays.stream(cities);
        List<String> stringList1 = citiesStram3.flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        System.out.println("stringList1 = " + stringList1);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        List<OrderLine> orderLines = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("collect1 = " + orderLines);
        //  .flatMap(x -> Arrays.stream(x))
              //  .collect(Collectors.toList());


    }
}
