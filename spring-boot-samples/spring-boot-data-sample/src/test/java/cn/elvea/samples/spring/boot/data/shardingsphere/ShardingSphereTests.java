package cn.elvea.samples.spring.boot.data.shardingsphere;

import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.MasterSlaveDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

/**
 * 读写分离单元测试
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("shardingsphere")
public class ShardingSphereTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void testCrud() {
        Assertions.assertNotNull(dataSource);
        Assertions.assertTrue(dataSource instanceof MasterSlaveDataSource);
    }

}
