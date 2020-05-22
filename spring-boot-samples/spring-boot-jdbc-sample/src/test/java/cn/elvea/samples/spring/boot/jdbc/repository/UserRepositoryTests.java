package cn.elvea.samples.spring.boot.jdbc.repository;

import cn.elvea.samples.spring.boot.jdbc.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userRepository);

        Optional<User> user = this.userRepository.findById(1L);
        Assertions.assertTrue(user.isPresent());
    }

}
