package com.learn.rest.webservices.restfulwebservices.user;

import com.learn.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20)));
    }


    public List<User> findAll() {
        return users;
    }

    public User findUserById(Integer id) {
        Optional<User> optionalUser = users.stream().filter(user -> id.equals(user.getId()))
                .findAny();
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User Not Found for id: "+ id);
        }

    }

    public User createUser(User user) {
        User newUser = new User(++userCount, user.getName(), user.getBirthDate());
        users.add(newUser);
        return newUser;
    }

    public void deleteById(Integer id) {
        Predicate<? extends User> predicate = user -> id.equals(user.getId());
        users.removeIf((Predicate<? super User>) predicate);
    }
}
