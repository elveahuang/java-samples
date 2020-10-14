package cn.elvea.samples.spring.boot.data.mybatis.mapper;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * UserMapperTests
 *
 * @author elvea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        Assertions.assertNotNull(this.userMapper);

        Date date = this.userMapper.getCurDate();
        Assertions.assertNotNull(date);

    }

}
