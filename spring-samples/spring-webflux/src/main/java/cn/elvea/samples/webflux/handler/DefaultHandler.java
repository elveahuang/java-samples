package cn.elvea.samples.webflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DefaultHandler {

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse.ok().body(BodyInserters.fromValue("Hello WebFlux"));
    }

}
