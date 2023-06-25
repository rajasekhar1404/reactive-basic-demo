package com.reactive.router;

import com.reactive.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunctions() {
        return RouterFunctions.route()
                .GET("/route/users", userHandler::getAllUsers)
                .GET("/route/users/{name}", userHandler::getUserByName)
                .POST("/route/users/save", userHandler::saveUser)
                .build();
    }


}
