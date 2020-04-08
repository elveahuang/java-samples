package cn.elvea.spring.boot.oauth.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * UserController
 *
 * @author elvea
 */
@RestController
@RequestMapping("/")
public class UserController {
    @RequestMapping("/user")
    public Object getUserInfo(@AuthenticationPrincipal Jwt principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("username", principal.getClaimAsString("username"));
        return Collections.unmodifiableMap(map);
    }
}
