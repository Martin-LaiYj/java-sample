package com.martin.mysample.demo.controller;

import com.martin.mysample.demo.pojo.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoRestController
 *
 * @author Martin
 * @since 2023-10-28 15:28
 **/

@RestController
public class DemoRestController {

    @PostMapping("/saveUser")
    public UserDTO saveUser(UserDTO userDTO) {
        return userDTO;
    }

    @ResponseBody
    @GetMapping("/test/user")
    public UserDTO testUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("martin11");
        userDTO.setAge(25);

        return userDTO;
    }


}
