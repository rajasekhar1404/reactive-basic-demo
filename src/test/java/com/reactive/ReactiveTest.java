package com.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveTest {

    @Test
    public void testMono() {
        Mono<?> rajasekhra = Mono.just("Rajasekhar")
                .then(Mono.error(new ArithmeticException("Invalid text")))
                .log();
        rajasekhra.subscribe(System.out::println);
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Raja", "Sekhar", "Karampudi", "Raj", "Aryan", "Rajkumar").log();
        fluxString.subscribe(System.out::println, err -> System.out.println(err.getMessage()));
    }

}
