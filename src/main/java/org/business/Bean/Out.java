package org.business.Bean;

/**
 * Created by wangz on 2016/12/6.
 */
public class Out {

    private Meta meta;
    private Object data;

    public Out(Meta meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
