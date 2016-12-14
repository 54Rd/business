package org.business.Bean;


import javax.persistence.*;

/**
 * Created by wangz on 2016/12/6.
 */
@Entity
@Table(name = "eb_user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userID;

    @Column(name = "username")
    private String userName;

    @Column(name = "realname")
    private String realName;

    public UserProfile() {
    }

    public UserProfile(String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
