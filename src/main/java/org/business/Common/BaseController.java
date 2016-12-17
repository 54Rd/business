package org.business.Common;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangz on 2016/12/7.
 */
public class BaseController {


    /**
     * @param view
     * @return
     */
    protected ModelAndView view$(String view){
        return new ModelAndView(view);
    }
}
