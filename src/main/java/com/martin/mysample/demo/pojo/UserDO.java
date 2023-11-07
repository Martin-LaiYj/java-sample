package com.martin.mysample.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * MyPo
 *
 * @author Martin
 * @since 2023-09-19 23:16
 **/

@Data
@TableName("t_user")
public class UserDO {

    @TableId
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "gender")
    private String gender;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "is_deleted")
    private Integer isDeleted;
}
