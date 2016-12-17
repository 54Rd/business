package org.business.Common.Out;

/**
 * Created by wangz on 2016/12/6.
 */
public enum Meta implements IMeta {

    Success(0, "成功"),
    FailToken(100, "TOKEN失效"),
    FailService(200, "服务不可用"),
    FailData(300, "数据库错误"),
    ErrorParam(400, "参数错误");

    private int code;
    private String msg;

    Meta(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }


    @Override
    public String getMsg() {
        return msg;
    }

}
