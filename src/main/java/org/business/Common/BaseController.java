package org.business.Common;

import org.business.Bean.Meta;
import org.business.Bean.Out;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangz on 2016/12/7.
 */
public class BaseController {

    /**
     * @param msg
     * @param data
     * @return
     */
    protected Out writeJsonSuccess(String msg, Object data){
        return new Out(new Meta(1,msg),data);
    }

    protected Out writeJsonSuccess(Object data){
        return writeJsonSuccess("okay",data);
    }

    /**
     * @param msg
     * @return
     */
    protected Out writeJsonFail(String msg){
        return new Out(new Meta(0,msg),null);
    }

    protected Out writeJsonFail(){
        return writeJsonFail("error");
    }

    /**
     * @param view
     * @return
     */
    protected ModelAndView view$(String view){
        return new ModelAndView(view);
    }
}
