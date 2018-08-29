package blog.services;

import blog.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean authenticate(String userName, String password) {
        boolean confirmed = false;
        if ("test".equals(userName) && "test1".equals(password)) {
            confirmed = true;
        }
        return confirmed;
    }

    @Override
    public boolean registerNewUser(User user) {
        return false;
    }
}
