package com.jeessicats.workshopmongo.config;

import com.jeessicats.workshopmongo.domain.Post;
import com.jeessicats.workshopmongo.domain.User;
import com.jeessicats.workshopmongo.dto.AuthorDTO;
import com.jeessicats.workshopmongo.repository.PostRepository;
import com.jeessicats.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User john = new User(null, "John Brown", "john@example.com");
        User olivia = new User(null, "Olivia Green", "olivia@example.com");
        User aurora = new User(null, "Aurora Grey", "aurora@example.com");

        userRepository.saveAll(Arrays.asList(john, olivia, aurora));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "The mystery of lost socks 🧦",
                "Do washing machines have a portal to another dimension? Because in my house, the socks that go in are never the same that come out.",
                new AuthorDTO(john));

        Post post2 = new Post(null, sdf.parse("22/03/2018"), "The burnt toast drama 🍞",
                "It’s amazing how 5 seconds can turn a perfect breakfast into smoke and despair. R.I.P., my toast.",
                new AuthorDTO(olivia));

        postRepository.saveAll(Arrays.asList(post1, post2));

        john.getPosts().add(post1);
        userRepository.save(john);
        olivia.getPosts().add(post2);
        userRepository.save(olivia);
    }
}

