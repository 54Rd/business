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

import java.util.List;

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

    @Autowired
    AuthService authService;

    @Override
    public Out createUser(String userName, String realName, String password) {
        if (userProfileRepository.findCountByUserName(userName) > 0) {
            return OutFactory.create(UserMeta.AccountRepeat);
        }

        UserProfile profile = userProfileRepository.save(new UserProfile(userName, realName));
        if (profile == null) {
            return OutFactory.create(Meta.FailData);
        }

        Long userID = profile.getUserID();
        UserAuthLocal userAuthLocal = userAuthRepository.save(new UserAuthLocal(userID, userName, password));
        if (userAuthLocal == null) {
            return OutFactory.create(Meta.FailData);
        }

        UserCon userCon = userConRepository.save(new UserCon(userID, 100, 0, 1));
        if (userCon == null) {
            return OutFactory.create(Meta.FailData);
        }

        final String mToken = authService.grantToken(userID);

        return OutFactory.create(Meta.Success, new Object() {
            public String token = mToken;
        });
    }

    /**
     * 禁止用户登陆
     *
     * @param userName
     * @return
     */
    @Override
    public Out banUserByUserName(String userName) {
        List<Long> userIDs = userProfileRepository.findUserIDByUserName(userName);
        if (userIDs == null) {
            return OutFactory.create(UserMeta.AccountNotExist);
        }

        for (Long userID : userIDs) {
            banUserByUserID(userID);
        }

        return OutFactory.create(Meta.Success);
    }

    @Override
    public Out banUserByUserID(Long userID) {
        List<UserCon> userCons = userConRepository.findByUserID(userID);
        if (userCons == null) {
            return OutFactory.create(UserMeta.AccountNotExist);
        }

        UserCon userCon = userCons.get(0);
        userCon.setIsLimit(1);
        userCon = userConRepository.save(userCon);
        if (userCon == null) {
            return OutFactory.create(Meta.FailData);
        }
        return OutFactory.create(Meta.Success);
    }

    @Override
    public Out loginUser(String userName, String password) {
        List<Long> userIDs = userProfileRepository.findUserIDByUserName(userName);

        if (userIDs == null) {//不存在userID
            return OutFactory.create(UserMeta.AccountError);
        }

        Long userID = userIDs.get(0);
        List<UserAuthLocal> authLocals = userAuthRepository.findByUserID(userID);
        if (authLocals == null) {//不存在密码
            return OutFactory.create(UserMeta.AccountError);
        }

        if (!authLocals.get(0).getPassword().equals(password)) {//密码不匹配
            return OutFactory.create(UserMeta.AccountError);
        }

        //验证成功
        final String t = authService.grantToken(userID);

        return OutFactory.create(Meta.Success,new Object(){
            public String token = t;
        });
    }

}
