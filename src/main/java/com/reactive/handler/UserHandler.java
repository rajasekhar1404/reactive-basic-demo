package com.reactive.handler;

import com.reactive.entity.User;
import com.reactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userRepository.getAllUsers(), User.class);
    }

    public Mono<ServerResponse> getUserByName(ServerRequest request) {
        String name = request.pathVariable("name");
        Flux<User> allUsers = userRepository.getAllUsers();
        Flux<User> filtered = allUsers.filter(each -> each.getName().equals(name));
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(filtered, User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class).log();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userMono, User.class);
    }

}
