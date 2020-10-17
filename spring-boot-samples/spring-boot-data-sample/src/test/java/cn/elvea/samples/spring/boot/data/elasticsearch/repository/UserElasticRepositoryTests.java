package cn.elvea.samples.spring.boot.data.elasticsearch.repository;

import cn.elvea.samples.spring.boot.data.elasticsearch.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserElasticRepositoryTests {
    @Autowired
    UserElasticRepository userElasticRepository;

    @Test
    public void testCrud() {
        Assertions.assertNotNull(userElasticRepository);

        User user = new User();
        user.setId(1L);
        user.setUsername("elvea");
        user.setNickname("Elvea Huang");
        user.setCreatedAt(new Date());
        this.userElasticRepository.save(user);

        Assertions.assertNotNull(user.getId());
    }

}
