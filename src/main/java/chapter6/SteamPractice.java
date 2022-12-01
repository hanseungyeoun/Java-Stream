package chapter6;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamPractice {
    public static void main(String[] args) {
        Stream<String> nameStream =  Stream.of("Alice", "Bob", "Charlie");
        List<String> mames = nameStream.collect(Collectors.toList());
        System.out.println("mames = " + mames);

        String[] ctiyArray = new String[]{"san", "seoul", "tokyo"};
        Stream<String> ctiyStream = Arrays.stream(ctiyArray);
        List<String> ctiyList = ctiyStream.collect(Collectors.toList());
        System.out.println("ctiyList = " + ctiyList);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("numberList = " + numberList);
    }
}
