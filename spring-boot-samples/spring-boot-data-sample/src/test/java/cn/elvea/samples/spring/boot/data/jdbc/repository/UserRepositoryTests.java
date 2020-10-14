package cn.elvea.samples.spring.boot.data.jdbc.repository;

import cn.elvea.samples.spring.boot.data.jdbc.domain.User;
import cn.elvea.samples.spring.boot.data.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
    UserJdbcRepository userRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userRepository);
        Assertions.assertNotNull(this.userMapper);
        User user = this.userRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(user);
        Date date = this.userMapper.getCurDate();
        Assertions.assertNotNull(date);
    }

}
