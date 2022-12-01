package chatper8;

import chatper8.model.Order;
import chatper8.model.OrderLine;

import chatper8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ReducePractice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);

        Integer sum = numbers.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println("sum = " + sum);

        Optional<Integer> min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y);

        System.out.println("sum = " + min.get());

        Integer product = numbers.stream()
                .reduce(1, (x, y) -> x * y);

        System.out.println("product = " + product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);

        Integer sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setFriendUserIds(Arrays.asList(204, 205, 207));
        List<User> users = Arrays.asList(user1, user2, user3);

        Integer sumNumbersOfFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);

        System.out.println("sumOfFriendIds = " + sumNumbersOfFriends);

        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        BigDecimal sumOfAmount = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(Collection::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        System.out.println("sumOfAmount = " + sumOfAmount);


    }
}
