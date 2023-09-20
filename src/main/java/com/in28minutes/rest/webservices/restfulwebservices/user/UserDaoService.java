package com.in28minutes.rest.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDaoService {
    // The Data Access Object is basically an object or an interface that provides access to an underlying database or any other persistence storage.

    // JPA/Hibernate to talk to Database

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Jayden", LocalDate.now().minusYears(30)));
        users.add(new User(2,"John", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim Carrey", LocalDate.now().minusYears(60)));
    }

    public List<User> findAll() {
        return users;
    }
    public User findById(int id) {

        return users.stream()
               .filter(user -> user.getId() == id) // Filter users with matching ID
                .findFirst() // Get the first matching user, or null if none found
                .orElse(null); // Return null if no matching user was found


//        SOLUTION 1:
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//       return users.stream().filter(predicate).findFirst().get();

//          SOLUTION 2:
//        for (User user : users) {
//            if(user.getId().equals(id)) {
//                return user;
//            }
//        }
//        // Return null if no user with the specified ID is found
//        return null;
    }
}
