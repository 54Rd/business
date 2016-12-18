package org.business.Controller;

import org.business.Common.Out.Meta;
import org.business.Common.Out.Out;
import org.business.Common.Out.OutFactory;
import org.business.Service.AuthService;
import org.business.Service.IndexService;
import org.business.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangz on 2016/12/6.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/token/{token}",method = RequestMethod.GET)
    public Out token(@PathVariable String token){

        return OutFactory.create(Meta.Success,authService.isTokenLegally(token)?"token合法":"token不合法");
    }


}
