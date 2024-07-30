package com.scalar.online_tickiting_platform_bms.services;

import com.scalar.online_tickiting_platform_bms.Exceptions.InvalidUserException;
import com.scalar.online_tickiting_platform_bms.Repositories.UserRepository;
import com.scalar.online_tickiting_platform_bms.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User SignUp(String EmailId, String password) throws InvalidUserException {
        Optional<User> optionaluser = userRepository.findByEmail(EmailId);
        // if user is present in database go to log in workflow else go on sign up workflow
        if(optionaluser.isPresent())
        {
            return login(EmailId, password);
        }
        User user = new User();
        user.setBooking(new ArrayList<>());
        user.setEmail(EmailId);
        user.setPassword(password);
        return userRepository.save(user);
    };
    public User login(String EmailId, String password)
    {
        return null;
    };
}
