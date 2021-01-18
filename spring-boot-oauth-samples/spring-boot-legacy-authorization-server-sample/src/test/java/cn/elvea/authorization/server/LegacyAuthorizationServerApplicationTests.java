package cn.elvea.authorization.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 认证服务器单元测试
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LegacyAuthorizationServerApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void defaultTests() throws Exception {
        this.mvc.perform(get("/").accept(MediaTypes.HAL_JSON)).andExpect(status().isUnauthorized());
    }

    @Test
    public void requestTokenWhenUsingPasswordGrantTypeThenOk() throws Exception {
        this.mvc.perform(post("/oauth/token")
                .param("grant_type", "password")
                .param("username", "admin")
                .param("password", "admin")
                .header("Authorization", "Basic cmVhZGVyOnNlY3JldA=="))
                .andExpect(status().isOk());
    }

    @Test
    public void requestJwkSet() throws Exception {
        this.mvc.perform(get("/.well-known/jwks.json"))
                .andExpect(status().isOk());
    }

}
