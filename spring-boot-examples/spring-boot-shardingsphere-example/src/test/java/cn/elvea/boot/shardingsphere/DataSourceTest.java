package cn.elvea.boot.shardingsphere;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback(false)
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void test() {
        Assertions.assertNotNull(dataSource);
    }

}
