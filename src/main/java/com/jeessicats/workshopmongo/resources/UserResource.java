package com.jeessicats.workshopmongo.resources;

import com.jeessicats.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "mariabrown@gmail.com");
        User alex = new User("2", "Alex Green", "alexgreen@gmail.com");
        List<User> users = new ArrayList<User>();
        users.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(users);
    }
}
