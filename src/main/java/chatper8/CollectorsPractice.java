package chatper8;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsPractice {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toList());

        Set<Integer> set = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toSet());


        List<Integer> mu = Stream.of(3, 5, -4, 2, 6)
                .collect(
                        Collectors.mapping(
                                x -> Math.abs(x),
                                Collectors.toList()
                        )
                );

        List<Integer> map = Stream.of(3, 5, -4, 2, 6)
                .collect(
                        Collectors.mapping(
                                x -> Math.abs(x),
                                Collectors.toList()
                        )
                );

        System.out.println("map = " + map);

        Set<Integer> set2 = Stream.of(3, 5, -4, 2, 6)
                .collect(
                        Collectors.mapping(
                                x -> Math.abs(x),
                                Collectors.toSet()
                        )
                );

        Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.reducing(0, (x, y) -> x + y));


    }
}
