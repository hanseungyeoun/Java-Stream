package chatper10.service;

import chatper10.model.User;

public class InternalUserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User user) {
        System.out.println("validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing user " + user.getName() + " to internal DB");
    }
}
