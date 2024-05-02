package cc.elvea.boot.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
    private String id;
    private String username;
}
