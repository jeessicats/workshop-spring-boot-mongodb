package com.jeessicats.workshopmongo.config;

import com.jeessicats.workshopmongo.domain.User;
import com.jeessicats.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User john = new User(null, "John Brown", "john@example.com");
        User olivia = new User(null, "Olivia Green", "olivia@example.com");
        User aurora = new User(null, "Aurora Grey", "aurora@example.com");

        userRepository.saveAll(Arrays.asList(john, olivia, aurora));
    }
}

