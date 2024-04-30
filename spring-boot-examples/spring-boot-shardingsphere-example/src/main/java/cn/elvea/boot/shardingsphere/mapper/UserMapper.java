package cn.elvea.boot.shardingsphere.mapper;

import cn.elvea.boot.shardingsphere.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
