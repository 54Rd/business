package org.business.Common.Out;

/**
 * Created by wangz on 2016/12/18.
 */
public class OutFactory {

    /**
     * 不带数据JSON
     * @param meta
     * @return
     */
    public static Out create(IMeta meta){
        return new Out(meta);
    }

    /**
     * 带数据JSON
     * @param meta
     * @param data
     * @return
     */
    public static Out create(IMeta meta,Object data){
        return new OutData(meta,data);
    }
}
