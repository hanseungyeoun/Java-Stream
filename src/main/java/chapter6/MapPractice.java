package chapter6;

import chapter6.model.Order;
import chapter6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chapter6.model.Order.OrderStatus.*;

public class MapPractice {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
/*        Stream<Integer> numberStream = numberList.stream();
        Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
        List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());*/

        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println("numberListX2 = " + numberListX2);

        List<String> stringList = numberList.stream()
                .map(x -> "number is " + x)
                .collect(Collectors.toList());
        System.out.println("stringList = " + stringList);

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
        List<String> emails = users.stream()
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println("emails = " + emails);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(CREATED)
                .setCreatedByUserId(101);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(IN_PROGRESS)
                .setCreatedByUserId(105);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> userIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());

        System.out.println("userIds = " + userIds);
    }
}
