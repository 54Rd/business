package org.business.Repository;

import org.business.Bean.UserAuthLocal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangz on 2016/12/12.
 */
public interface UserAuthRepository extends CrudRepository<UserAuthLocal,Long> {

    UserAuthLocal findByUserID(Long userID);
}
