package cn.elvea.samples.spring.boot.hander;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
public class UserHander {

    public ServerResponse handleIndex(ServerRequest request) {
        return ok().body("Hello World.");
    }

}
