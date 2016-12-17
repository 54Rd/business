package org.business.Common.Out;

/**
 * Created by wangz on 2016/12/17.
 */
public class OutData extends Out {

    private Object data;

    public OutData(IMeta meta, Object data) {
        super(meta);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
