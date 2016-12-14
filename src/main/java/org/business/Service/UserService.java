package org.business.Service;

import org.business.Bean.UserProfile;

/**
 * Created by wangz on 2016/12/8.
 */
public interface UserService  {

    boolean createUser(String userName,String realName,String password);

    boolean banUserByUserName(String userName);

    boolean banUserByUserID(Long userID);

    boolean deleteUserByUserID(Long userID);

    int findCountByUserName(String userName);

}
