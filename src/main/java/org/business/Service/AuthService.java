package org.business.Service;

/**
 * Created by wangz on 2016/12/14.
 */
public interface AuthService {

    boolean isTokenLegally(String mToken,String userName);

    String grantToken(String userName);
}
