package chatper10;

import chatper10.model.User;

public class BuilderPatternPractice {
    public static void main(String[] args) {
        /*
        User user = User.builder(1, "Alice")
                .withEmailAddredd("alice@naver.com")
                .withVerified(true)
                .build();

         */
        User user = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@naver.com";
                    builder.isVerified = true;
                }).build();
    }
}
