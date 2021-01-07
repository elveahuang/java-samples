package cn.elvea.authorization.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 传统认证服务器
 *
 * @author elvea
 */
@SpringBootApplication
public class LegacyAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegacyAuthorizationServerApplication.class, args);
    }

}
