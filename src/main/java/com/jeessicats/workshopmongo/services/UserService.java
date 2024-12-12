package com.jeessicats.workshopmongo.services;

import com.jeessicats.workshopmongo.domain.User;
import com.jeessicats.workshopmongo.dto.UserDTO;
import com.jeessicats.workshopmongo.repository.UserRepository;
import com.jeessicats.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public User fromDto(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}