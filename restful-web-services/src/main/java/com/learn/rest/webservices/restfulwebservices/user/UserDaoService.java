package com.learn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return users.stream().filter(user -> id.equals(user.getId()))
                .findAny().orElse(null);
    }

    public User createUser(User user) {
        User newUser = new User(++userCount, user.getName(), user.getBirthDate());
        users.add(newUser);
        return newUser;
    }
}
