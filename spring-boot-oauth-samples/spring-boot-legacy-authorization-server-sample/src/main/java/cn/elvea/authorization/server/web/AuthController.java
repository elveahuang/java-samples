package cn.elvea.authorization.server.web;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AuthController
 *
 * @author elvea
 */
@Controller
public class AuthController {

    final TokenStore tokenStore;

    public AuthController(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/introspect")
    @ResponseBody
    public Map<String, Object> introspect(@RequestParam("token") String token) {
        OAuth2AccessToken accessToken = this.tokenStore.readAccessToken(token);
        Map<String, Object> attributes = new HashMap<>();
        if (accessToken == null || accessToken.isExpired()) {
            attributes.put("active", false);
            return attributes;
        }

        OAuth2Authentication authentication = this.tokenStore.readAuthentication(token);

        attributes.put("active", true);
        attributes.put("exp", accessToken.getExpiration().getTime());
        attributes.put("scope", accessToken.getScope().stream().collect(Collectors.joining(" ")));
        attributes.put("sub", authentication.getName());

        return attributes;
    }
}
