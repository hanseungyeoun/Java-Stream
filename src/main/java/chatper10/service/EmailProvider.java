package chatper10.service;

import chatper10.model.User;

public interface EmailProvider {
    String getEmail(User user);
}
