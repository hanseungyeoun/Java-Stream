package chatper8;



import chatper8.model.Order;
import chatper8.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static chatper8.model.Order.*;
import static chatper8.model.Order.OrderStatus.*;
import static java.math.BigDecimal.*;
import static java.util.Comparator.*;

public class MaxMinCountPractice {
    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
                //.max((x, y) -> x - -y);
                .max(Integer::compareTo);

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

//        List<User> users = Arrays.asList(user1, user2, user3);
//        User min = users.stream()
//                //.min((x, y) -> x.getName().compareTo(y.getName()));
//                //.min(comparing(User::getName)).get();
//                .min(comparing(x->x.getName())).get();
//        System.out.println("min = " + min);

        long positiveIntegerCont = Stream.of(1, -4, 5, -3, 6)
                .filter(x-> x > 0)
                .count();
        System.out.println("positiveIntegerCont = " + positiveIntegerCont);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@fastcampus.co.kr")
                .setCreatedAt(now.minusHours(27));
        users = Arrays.asList(user1, user2, user3, user4);

        long count = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();

        System.out.println("count = " + count);

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

        // TODO: find order with highest amount an in ERROR status
        Order maxOrder = orders.stream()
                .filter(order -> order.getStatus() == ERROR)
                .max(comparing(Order::getAmount))
                .get();

        System.out.println("order = " + maxOrder);
                

    }
}
