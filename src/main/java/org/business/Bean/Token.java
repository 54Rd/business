package org.business.Bean;

import java.io.Serializable;

/**
 * Created by wangz on 2016/12/16.
 */
public class Token implements Serializable {

    private static final long serialVersionUID = -1L;

    private String token;
    private Long createTime;
    private Long expiredTime;
    private Long userID;
    private int count = 0;

    public Token() {
    }

    public Token(String token, Long createTime, Long expiredTime, Long userID) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTime = expiredTime;
        this.userID = userID;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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

    public void addCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", createTime=" + createTime +
                ", expiredTime=" + expiredTime +
                ", userID=" + userID +
                ", count=" + count +
                '}';
    }
}
