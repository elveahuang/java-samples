package cn.elvea.authorization.server.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {

    @GetMapping("/user")
    public Object getUserInfo(@AuthenticationPrincipal Jwt principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("username", principal.getClaimAsString("username"));
        return Collections.unmodifiableMap(map);
    }

}
