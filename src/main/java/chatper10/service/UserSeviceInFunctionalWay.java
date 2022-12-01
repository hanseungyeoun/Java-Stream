package chatper10.service;


import chatper10.model.User;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserSeviceInFunctionalWay {
    private final Predicate<User> validataUser;
    private final Consumer<User> writeToDB;

    public UserSeviceInFunctionalWay(Predicate<User> validataUser, Consumer<User> writeToDB){
        this.validataUser = validataUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(User user){
        if(validataUser.test(user)){
            writeToDB.accept(user);
        } else{
            System.out.println("Cannot create user");
        }
    }

}
