package org.business.Service;

import org.business.Bean.Token;
import org.business.Bean.UserProfile;
import org.business.Config.SecretKeySettings;
import org.business.Repository.Redis.TokenRedis;
import org.business.Repository.UserProfileRepository;
import org.business.Utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wangz on 2016/12/14.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TokenRedis tokenRedis;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Value("${env.token.expired-time-mi}")
    private int expired;

    @Autowired
    private SecretKeySettings secretKeySettings;


    public boolean isTokenLegally(String mToken) {
        Token token = tokenRedis.getToken(mToken);
        if (token == null) {
            return false;
        }

        long time = System.currentTimeMillis();
        if (token.getExpiredTime() - time <= 0) {
            return false;
        }
        token.addCount();

        System.out.println(token.toString());
        return true;
    }

    @Override
    public String grantToken(Long userID) {
        Long expiredTime = System.currentTimeMillis() + expired * 60 * 1000;
        String t = String.valueOf(userID) + secretKeySettings.getKey() + String.valueOf(expiredTime);
        String t2 = EncryptUtils.md5(t).substring(3, 28) + String.valueOf(System.currentTimeMillis()).substring(4, 9);
        String tokenStr = EncryptUtils.md5(t2);
        Token token = new Token(tokenStr, System.currentTimeMillis(), expiredTime, userID);
        tokenRedis.setToken(tokenStr, token);

        System.out.println(token.toString());
        return tokenStr;
    }
}
