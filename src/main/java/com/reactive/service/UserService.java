package com.reactive.service;

import com.reactive.entity.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class UserService {

    public List<User> getAllUsers() {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .peek(i -> System.out.println("user" + i))
                .mapToObj(i -> new User("user" + i, "email"+i)).toList();
    }

    public Flux<User> getAllUsersFlux() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(System.out::println)
                .map(i -> new User("user" + i, "email" + i));
    }

}
