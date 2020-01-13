package com.hello.mongodb;

import com.hello.mongodb.entity.User;
import com.hello.mongodb.service.UserService;
import com.mongodb.util.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

@Slf4j
public class HelloTest extends BaseTestCase{

    @Resource
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setId(1L);
        user.setUserName("zns");
        user.setPassWord("helloworld");
        userService.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("hello");
        log.info(user.toString());
    }
}
