package chapter6;

import chapter6.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static chapter6.model.Order.OrderStatus.*;
import static java.util.Comparator.*;

public class DistinctPractice
{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2, 3);
        
        Integer[] distictNumbers = numbers.stream()
                .distinct()
                .toArray(Integer[]::new);

        for (Integer integer : distictNumbers) {
            System.out.println("integer = " + integer);
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(1));

        Order order2 = new Order()
                .setId(1002)
                .setStatus(ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(36));

        Order order3 = new Order()
                .setId(1003)
                .setStatus(PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(15));

        Order order4 = new Order()
                .setId(1004)
                .setStatus(ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(15));

        Order order5 = new Order()
                .setId(1005)
                .setStatus(IN_PROGRESS)
                .setCreatedByUserId(105)
                .setCreatedAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Long> userIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("userIds = " + userIds);

    }
}
