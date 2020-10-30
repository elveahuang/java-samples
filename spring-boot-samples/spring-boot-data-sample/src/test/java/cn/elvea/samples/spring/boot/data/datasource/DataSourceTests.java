package cn.elvea.samples.spring.boot.data.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 读写分离单元测试
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataSourceTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Assertions.assertNotNull(dataSource);
        Assertions.assertNotNull(dataSource.getConnection());
    }

}
