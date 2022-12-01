package chapter6;

import chapter6.model.Order;
import chapter6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chapter6.model.Order.OrderStatus.*;
import static java.util.Comparator.comparing;

public class SortPractice2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, 7, 4);
        List<Integer> sortedList = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("sortedList = " + sortedList);

        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3);

        List<User> sortedUsers = users.stream()
                .sorted(comparing(User::getName))
                .collect(Collectors.toList());

        System.out.println("sortedUsers = " + sortedUsers);

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

        List<Order> orderList = orders.stream()
                .sorted(comparing(Order::getCreatedAt))
                .collect(Collectors.toList());

        System.out.println("orderList = " + orderList);
        
    }
}
