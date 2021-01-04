package cn.elvea.authorization.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器
 *
 * @author elvea
 */
@SpringBootApplication
public class AuthorizationServer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServer.class, args);
    }

}
