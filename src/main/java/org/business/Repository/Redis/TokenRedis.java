package org.business.Repository.Redis;

import org.business.Bean.Token;
import org.business.Config.SecretKeySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by wangz on 2016/12/17.
 */
@Component
public class TokenRedis {

    @Autowired
    private RedisTemplate<String, Token> redisTemplate;

    public Token getToken(String token) {
        return redisTemplate.opsForValue().get(token);
    }


    public void setToken(String tokenK, Token tokenV) {
        redisTemplate.opsForValue().set(tokenK, tokenV);
    }


}
