package cn.elvea.samples.spring.boot.data.jpa.repository;

import cn.elvea.samples.spring.boot.data.jpa.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserJpaRepositoryTests {
    @Autowired
    UserJpaRepository userJpaRepository;

    @Test
    public void testCrud() {
        Assertions.assertNotNull(userJpaRepository);

        User user = new User();
        user.setId(1L);
        user.setUsername("elvea");
        user.setNickname("Elvea Huang");
        user.setCreatedAt(new Date());
        this.userJpaRepository.save(user);

        Assertions.assertNotNull(user.getId());
    }

}
