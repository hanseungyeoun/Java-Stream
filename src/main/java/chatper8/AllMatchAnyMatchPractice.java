package chatper8;

import chatper8.model.Order;
import chatper8.model.User;

import java.util.Arrays;
import java.util.List;

import static chatper8.model.Order.OrderStatus.*;
import static java.math.BigDecimal.valueOf;

public class AllMatchAnyMatchPractice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPostive = numbers.stream()
                .allMatch(number -> number > 0);

        System.out.println("allPosive = " + allPostive);

        boolean anyNagative = numbers.stream()
                .anyMatch(number -> number > 0);

        System.out.println("anyNagative = " + anyNagative);

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
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3);

        boolean areAllUserVerified = users.stream()
                .allMatch(User::isVerified);

        System.out.println("areAllUserVerified = " + areAllUserVerified);

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(valueOf(2000))
                .setStatus(CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(valueOf(4000))
                .setStatus(ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(valueOf(3000))
                .setStatus(ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(valueOf(7000))
                .setStatus(PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean isAnyOrderInErrorStatus = orders.stream()
                .anyMatch(order -> order.getStatus() == ERROR);

        System.out.println("isAnyOrderInErrorStatus = " + isAnyOrderInErrorStatus);

    }
}
