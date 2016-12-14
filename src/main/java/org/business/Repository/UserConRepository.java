package org.business.Repository;

import org.business.Bean.UserCon;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangz on 2016/12/12.
 */
public interface UserConRepository extends CrudRepository<UserCon,Long>{

    UserCon  findByUserID(Long userID);
}
