package org.business.Service;

import org.business.Common.Out.Out;

/**
 * Created by wangz on 2016/12/8.
 */
public interface UserService  {

    Out createUser(String userName, String realName, String password);

    Out banUserByUserName(String userName);

    Out banUserByUserID(Long userID);

    Out loginUser(String userName,String password);

}
