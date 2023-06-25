package com.reactive.repository;

import com.reactive.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class UserRepository {

    public Flux<User> getAllUsers() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new User("name " + i, "email " + i));
    }

}
