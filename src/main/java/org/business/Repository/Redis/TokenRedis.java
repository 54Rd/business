package org.business.Repository.Redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.business.Bean.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangz on 2016/12/17.
 */
@Component
public class TokenRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 从KV数据库拿到Token
     *
     * @param token
     * @return
     */
    public Token getToken(String token) {
        String json = redisTemplate.opsForValue().get(token);
        if (json != null) {
            try {
                Token t = objectMapper.readValue(json, Token.class);
                return t;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 保存Token并设置过期时间
     *
     * @param tokenK
     * @param tokenV
     */
    public void setToken(String tokenK, Token tokenV) {
        try {
            String json = objectMapper.writeValueAsString(tokenV);
            redisTemplate.opsForValue().set(tokenK, json);
            redisTemplate.expire(tokenK, tokenV.getExpiredTime(), TimeUnit.MILLISECONDS);
            setTokenByUserID(tokenV.getUserID(), tokenK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删掉原来的TOKEN
     *
     * @param token
     */
    public void clearToken(String token) {
        redisTemplate.delete(token);
    }


    private void setTokenByUserID(Long userID, String token) {
        redisTemplate.opsForValue().set(String.valueOf(userID), token);
    }

    public String getTokenByUserID(Long userID) {
        return redisTemplate.opsForValue().get(String.valueOf(userID));
    }


}
