package chatper7;

import chatper7.model.User;

import java.util.Optional;

public class Otpional2Practice {
    public static void main(String[] args) {
        Optional<User> maybeGetUser = Optional.ofNullable(maybeGetUser(true));
        maybeGetUser.ifPresent(System.out::println);

        Optional<Integer> maybyId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        System.out.println("maybyId = " + maybyId);

        String maybyName = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getName())
                .map(name -> "this name is " + name)
                .orElse("name is empty");

        Optional<String> maybeEamil = Optional.ofNullable(maybeGetUser(false))
                .flatMap(User::getEmailAddress);

        maybeEamil.ifPresent(System.out::println);

    }
    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@fastcampus.co.kr")
                    .setVerified(false);
        }
        return null;
    }
}
