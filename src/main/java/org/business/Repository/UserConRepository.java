package org.business.Repository;

import org.business.Bean.UserCon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangz on 2016/12/12.
 */
public interface UserConRepository extends CrudRepository<UserCon,Long>{

    @Query("select con from UserCon con where con.userID=:userID and con.dataStatus=1  order by con.updateTime desc")
    List<UserCon> findByUserID(@Param("userID") Long userID);
}
