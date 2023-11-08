package com.martin.mysample.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.martin.mysample.demo.mapper.UserMapper;
import com.martin.mysample.demo.model.UserDO;
import com.martin.mysample.demo.model.UserVO;
import com.martin.mysample.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MyServiceImpl
 *
 * @author Martin
 * @since 2022-05-26 10:17
 **/

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void printUserVo(String name) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getName, name);
        UserDO po = getOne(wrapper);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(po, vo);
//        System.out.println(vo);
        log.info(String.valueOf(vo));
//        System.out.println("Today is the day!");
    }

    @Override
    public UserDO selectUserByName(String name) {
        return userMapper.selectUserByName(name, "");
    }

}