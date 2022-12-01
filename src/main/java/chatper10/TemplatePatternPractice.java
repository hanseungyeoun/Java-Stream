package chatper10;

import chatper10.model.User;
import chatper10.service.InternalUserService;
import chatper10.service.UserService;
import chatper10.service.UserSeviceInFunctionalWay;

import java.util.Arrays;

public class TemplatePatternPractice {
    public static void main(String[] args) {
        User alice = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();
        internalUserService.createUser(alice);

        UserSeviceInFunctionalWay userSeviceInFunctionalWay = new UserSeviceInFunctionalWay(
                user -> {
                    System.out.println("Validating user " + user.getName());
                    return user.getName() != null && user.getEmailAddress().isPresent();
                },
                user -> {
                    System.out.println("Validating user " + user.getName() + " to db");
                }
        );
        userSeviceInFunctionalWay.createUser(alice);

    }
}
