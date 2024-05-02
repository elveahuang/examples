package cc.elvea.boot.shardingsphere.mapper;

import cc.elvea.boot.shardingsphere.Application;
import cc.elvea.boot.shardingsphere.entity.User;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback(false)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        Assertions.assertNotNull(userMapper);
        List<User> list = userMapper.selectList(Wrappers.emptyWrapper());
        Assertions.assertTrue(list.isEmpty());
    }

}
