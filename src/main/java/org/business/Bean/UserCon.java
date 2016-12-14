package org.business.Bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by wangz on 2016/12/12.
 */
@Entity
@Table(name = "eb_user_con")
public class UserCon {

    @Id
    @Column(name = "userid")
    private Long userID;
    @Column(name = "roleid")
    private int roleID;
    @Column(name = "islimit")
    private int isLimit;
    @Column(name = "datastatus")
    private int DataStatus;
    @Column(name = "inserttime",insertable = false,updatable = false)
    private Timestamp insertTime;

    public UserCon() {
    }

    public UserCon(Long userID, int roleID, int isLimit, int dataStatus) {
        this.userID = userID;
        this.roleID = roleID;
        this.isLimit = isLimit;
        DataStatus = dataStatus;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(int isLimit) {
        this.isLimit = isLimit;
    }

    public int getDataStatus() {
        return DataStatus;
    }

    public void setDataStatus(int dataStatus) {
        DataStatus = dataStatus;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }
}
