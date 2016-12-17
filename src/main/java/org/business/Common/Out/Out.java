package org.business.Common.Out;

/**
 * Created by wangz on 2016/12/6.
 */
public class Out {

    private Object meta;

    public Out(IMeta meta) {
        this.meta = new MetaObj(meta.getCode(),meta.getMsg());
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(MetaObj meta) {
        this.meta = meta;
    }

    private static class MetaObj {

        private int code;
        private String msg;

        public MetaObj(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
