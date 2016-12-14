package org.business.Service;

import org.business.Bean.UserAuthLocal;
import org.business.Bean.UserCon;
import org.business.Bean.UserProfile;
import org.business.Repository.UserAuthRepository;
import org.business.Repository.UserConRepository;
import org.business.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangz on 2016/12/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserConRepository userConRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public boolean createUser(String userName, String realName, String password) {
        UserProfile profile = userProfileRepository.save(new UserProfile(userName,realName));
        if (profile==null) {
            return false;
        }

        Long userID = profile.getUserID();
        UserAuthLocal userAuthLocal = userAuthRepository.save(new UserAuthLocal(userID,userName,password));
        if (userAuthLocal==null){
            return false;
        }

        UserCon userCon = userConRepository.save(new UserCon(userID,100,0,1));
        if(userCon==null){
            return false;
        }

        return true;
    }

    @Override
    public boolean banUserByUserName(String userName) {



        return false;
    }

    @Override
    public boolean banUserByUserID(Long userID) {
        UserCon userCon = userConRepository.findByUserID(userID);
        userCon.setIsLimit(1);
        userCon = userConRepository.save(userCon);
        if(userCon==null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUserByUserID(Long userID) {
        UserCon userCon = userConRepository.findByUserID(userID);
        userCon.setDataStatus(0);
        userCon = userConRepository.save(userCon);
        if(userCon==null) {
            return false;
        }
        return true;
    }

    @Override
    public int findCountByUserName(String userName) {
        return userProfileRepository.findCountByUserName(userName);
    }
}
