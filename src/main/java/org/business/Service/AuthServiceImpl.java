package org.business.Service;

import org.business.Bean.Token;
import org.business.Repository.Redis.TokenRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangz on 2016/12/14.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TokenRedis tokenRedis;


    @Override
    public boolean isTokenLegally(String mToken) {
        Token token = tokenRedis.getToken(mToken);
        if (token == null) {
            return false;
        }

        long time = System.currentTimeMillis();
        if (token.getExpiredTime() - time <= 0) {
            return false;
        }

        return false;
    }

    @Override
    public String grantToken(String userName) {
        return null;
    }
}
