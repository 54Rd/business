package org.business;

import org.business.Service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangz on 2016/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserService userService;

    String username = "admin";
    String realname = "isme";
    String password= "#TGSDGQWTW#$#GSEG";

    @Before
    public void init(){



    }

    @Test
    public void test(){
        Assert.assertEquals(true,userService.createUser(username,realname,password));
//        Assert.assertEquals(true,userService.banUserByUserID((long) 100015));
//        Assert.assertEquals(true,userService.deleteUserByUserID((long) 100015));
    }

}
