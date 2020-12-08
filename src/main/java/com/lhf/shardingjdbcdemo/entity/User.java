package com.lhf.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class User {

    private Long userId;
    private String userName;
    private String status;

    public User(String userName,String status){
        this.userName = userName;
        this.status = status;
    }
}
