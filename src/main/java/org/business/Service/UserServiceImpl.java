package org.business.Service;

import org.business.Bean.UserAuthLocal;
import org.business.Bean.UserCon;
import org.business.Bean.UserMeta;
import org.business.Bean.UserProfile;
import org.business.Common.Out.Meta;
import org.business.Common.Out.Out;
import org.business.Common.Out.OutFactory;
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
    public Out createUser(String userName, String realName, String password) {
        if(userProfileRepository.findCountByUserName(userName)>0){
            return OutFactory.create(UserMeta.AccountRepeat);
        }

        UserProfile profile = userProfileRepository.save(new UserProfile(userName,realName));
        if (profile==null) {
            return OutFactory.create(Meta.FailData);
        }

        Long userID = profile.getUserID();
        UserAuthLocal userAuthLocal = userAuthRepository.save(new UserAuthLocal(userID,userName,password));
        if (userAuthLocal==null){
            return OutFactory.create(Meta.FailData);
        }

        UserCon userCon = userConRepository.save(new UserCon(userID,100,0,1));
        if(userCon==null){
            return OutFactory.create(Meta.FailData);
        }

        return OutFactory.create(Meta.Success);
    }

    @Override
    public Out banUserByUserName(String userName) {
        Long userID = findUserIDByUserName(userName);
        return banUserByUserID(userID);
    }

    @Override
    public Out banUserByUserID(Long userID) {
        UserCon userCon = userConRepository.findByUserID(userID);
        userCon.setIsLimit(1);
        userCon = userConRepository.save(userCon);
        if(userCon==null) {
            return OutFactory.create(Meta.FailData);
        }
        return OutFactory.create(Meta.Success);
    }

    public Long findUserIDByUserName(String userName){
        return userProfileRepository.findUserIDByUserName(userName);
    }

}
