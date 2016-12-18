package org.business.Repository;

import org.business.Bean.UserAuthLocal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangz on 2016/12/12.
 */
public interface UserAuthRepository extends CrudRepository<UserAuthLocal,Long> {

    @Query("select a from UserAuthLocal a where a.userID = :userID order by a.updateTime desc")
    List<UserAuthLocal> findByUserID(@Param("userID") Long userID);

}
