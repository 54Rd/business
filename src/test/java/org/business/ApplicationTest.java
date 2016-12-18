package org.business;

import org.business.Bean.Token;
import org.business.Repository.Redis.TokenRedis;
import org.business.Service.AuthService;
import org.business.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangz on 2016/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    private RedisTemplate<String,Token> redisTemplate;

    @Autowired
    private TokenRedis tokenRedis;

    public void testToken(){

//        Assert.assertEquals(true,authService.isTokenLegally(token));
    }

    @Test
    public void testRedis(){
        String token ="20227AB11AD52558EC555F97FC6C950C";
//        Token t = redisTemplate.opsForValue().get(token);
        Token t = tokenRedis.getToken(token);
        Assert.assertEquals(111L,t.getUserID().longValue());
    }
}
