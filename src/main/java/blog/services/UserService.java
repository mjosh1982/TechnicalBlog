package blog.services;

import blog.model.User;

public interface UserService {
    boolean authenticate(String userName,String password);
    boolean registerNewUser(User user);
}
