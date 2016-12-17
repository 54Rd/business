package org.business.Bean;

import org.business.Common.Out.IMeta;

/**
 * Created by wangz on 2016/12/17.
 */
public enum UserMeta implements IMeta {

    AccountRepeat(4001,"该账户已被注册");

    private int code;
    private String msg;

    UserMeta(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
