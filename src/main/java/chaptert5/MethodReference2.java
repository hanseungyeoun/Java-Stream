package chaptert5;

import chaptert5.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReference2 {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello world");
        //System.out.println("length = " + length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean hello = strEquals.test("hello", "world");
        //System.out.println("hello = " + hello);

        List<User> users = new ArrayList<>();
        users.add(new User(1, "aaa"));
        users.add(new User(2, "bbb"));
        users.add(new User(3, "ccc"));
        users.add(new User(4, "ddd"));


        //printUserField(users, user -> user.getId());
        printUserField(users, User::getId);
        printUserField(users, User::getName);

    }

    public static void printUserField(List<User> users, Function<User, Object> getter){
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}
