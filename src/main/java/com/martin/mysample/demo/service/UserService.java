package com.martin.mysample.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.martin.mysample.demo.pojo.UserDO;

/***
 * SqlToXmlService
 *
 * @author Martin
 * @since 2022-5-26
 */
public interface UserService extends IService<UserDO> {

    String str = "aaa";

    void printUserVo(String name);

    UserDO selectUserByName(String name);

}
