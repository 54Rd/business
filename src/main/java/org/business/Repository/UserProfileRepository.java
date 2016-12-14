package org.business.Repository;


import org.business.Bean.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wangz on 2016/12/8.
         */
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

    UserProfile findByUserID(Long userID);

    @Query("select count(1) from UserProfile where username = :username")
    int findCountByUserName(@Param("username") String username);

}
