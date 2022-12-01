package chapter6;

import chapter6.model.Order;
import chapter6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chapter6.model.Order.OrderStatus.*;

public class FilterPractice {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, 5, 7, 10, -3);
        Stream<Integer> filterednumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filterdNumberd = filterednumberStream.collect(Collectors.toList());
        System.out.println("filterdNumberd = " + filterdNumberd);

        List<Integer> newFilterdNumbers = Stream.of(3, 5, 7, 10, -3)
                .filter(x -> x > 0)
                .collect(Collectors.toList());

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(true)
                .setEmailAddress("charlie@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3);
        List<User> verifiedUsers = users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
        System.out.println(verifiedUsers);

        List<User> unverifiedUsers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unverifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(CREATED);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        // TODO: Filter orders in ERROR state
        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus() == ERROR)
                .collect(Collectors.toList());

        System.out.println("errorOrders = " + errorOrders);
    }
}
