package org.business.Bean;

import java.io.Serializable;

/**
 * Created by wangz on 2016/12/16.
 */
public class Token implements Serializable {

    private static final long serialVersionUID = -1L;

    private String token;
    private Long expiredTime;
    private Long userID;
    private int count = 0;

    public Token() {
    }

    public Token(String token, Long expiredTime, Long userID, int count) {
        this.token = token;
        this.expiredTime = expiredTime;
        this.userID = userID;
        this.count = count;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
