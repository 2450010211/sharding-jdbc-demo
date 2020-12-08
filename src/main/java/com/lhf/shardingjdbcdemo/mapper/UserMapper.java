package com.lhf.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhf.shardingjdbcdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
