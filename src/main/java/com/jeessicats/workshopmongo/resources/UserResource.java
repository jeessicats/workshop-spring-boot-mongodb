package com.jeessicats.workshopmongo.resources;

import com.jeessicats.workshopmongo.domain.User;
import com.jeessicats.workshopmongo.dto.UserDTO;
import com.jeessicats.workshopmongo.repository.UserRepository;
import com.jeessicats.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users =  userService.findAll();
        List<UserDTO> userDTOs = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOs);
    }
}
