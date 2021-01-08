package cn.elvea.authorization.server.web;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JwkController
 *
 * @author elvea
 */
@RestController
public class JwkController {

    private final JWKSet jwkSet;

    public JwkController(JWKSet jwkSet) {
        this.jwkSet = jwkSet;
    }

    @GetMapping("/.well-known/jwks.json")
    public String keys() {
        return this.jwkSet.toString();
    }

}
