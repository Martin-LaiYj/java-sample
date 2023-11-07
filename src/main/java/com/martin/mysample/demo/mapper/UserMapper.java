package com.martin.mysample.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.martin.mysample.demo.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyMapper
 *
 * @author Martin
 * @since 2023-09-19 23:17
 **/

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    int insertUser(@Param("user") UserDO userDO);

    UserDO selectUserByName(@Param("name") String name, String id);

    List<UserDO> selectAllUser();
}
