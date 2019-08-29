package com.jacky.learn.shiro.test.service;

import com.jacky.learn.shiro.LearnShiroApplicationTests;
import com.jacky.learn.shiro.entity.User;
import com.jacky.learn.shiro.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserService_Tests extends LearnShiroApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void save_test() {
        User user = new User();
        user.setUserName("张三");
        userService.save(user);

        List<User> users = userService.find(user);

        assertEquals(1, users.size());

        assertEquals("张三", users.get(0).getUserName());
    }
}
