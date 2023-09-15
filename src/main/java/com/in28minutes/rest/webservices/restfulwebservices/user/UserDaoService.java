package com.in28minutes.rest.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // The Data Access Object is basically an object or an interface that provides access to an underlying database or any other persistence storage.

    // JPA/Hibernate to talk to Database

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Jayden", LocalDate.now().minusYears(30)));
        users.add(new User(2,"John", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim Carrey", LocalDate.now().minusYears(60)));
    }

    public List<User> findAll() {
        return users;
    }
}
