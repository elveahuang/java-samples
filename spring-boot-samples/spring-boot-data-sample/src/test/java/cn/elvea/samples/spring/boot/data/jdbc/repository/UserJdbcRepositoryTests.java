package cn.elvea.samples.spring.boot.data.jdbc.repository;

import cn.elvea.samples.spring.boot.data.jdbc.domain.User;
import cn.elvea.samples.spring.boot.data.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserJdbcRepositoryTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserJdbcRepository userJdbcRepository;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userJdbcRepository);
        Assertions.assertNotNull(this.userMapper);
        User user = this.userJdbcRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(user);
        Date date = this.userMapper.getCurDate();
        Assertions.assertNotNull(date);
    }

}
