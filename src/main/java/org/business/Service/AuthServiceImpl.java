package org.business.Service;

import org.springframework.stereotype.Service;

/**
 * Created by wangz on 2016/12/14.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public boolean isTokenLegally(String mToken, String userName) {
        return false;
    }

    @Override
    public String grantToken(String userName) {
        return null;
    }
}
