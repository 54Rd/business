package org.business.Controller;

import org.business.Common.Out.Meta;
import org.business.Common.Out.Out;
import org.business.Common.BaseController;
import org.business.Common.Out.OutFactory;
import org.business.Service.UserService;
import org.business.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangz on 2016/12/7.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerForm(Model model) {
        return view$("user/reg");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Out register(@RequestParam(value = "username") String name,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "realname") String realname) {

        if (StringUtils.anyEmpty(name, password, realname)) {
            return OutFactory.create(Meta.ErrorParam);
        }

        return userService.createUser(name, realname, password);
    }
}
