package cn.elvea.samples.spring.boot.jdbc.repository;

import cn.elvea.samples.spring.boot.jdbc.domain.User;
import cn.elvea.samples.spring.boot.jdbc.mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userRepository);

//        User u1 = this.userRepository.findById(1L).orElse(null);
        User u2 = this.userRepository.findById(1L).orElse(null);
        System.out.println(u2);
        this.userMapper.getCurDate();
        System.out.println("123");

    }

}
