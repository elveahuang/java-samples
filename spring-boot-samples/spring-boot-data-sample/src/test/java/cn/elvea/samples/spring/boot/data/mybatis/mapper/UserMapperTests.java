package cn.elvea.samples.spring.boot.data.mybatis.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

/**
 * UserMapperTests
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
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
