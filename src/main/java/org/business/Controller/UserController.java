package org.business.Controller;

import org.business.Bean.UserMeta;
import org.business.Common.Out.Meta;
import org.business.Common.Out.Out;
import org.business.Common.BaseController;
import org.business.Common.Out.OutFactory;
import org.business.Service.UserService;
import org.business.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.GET)
    public Out login(@PathVariable String username,@PathVariable String password){
        if(StringUtils.anyEmpty(username,password)){
            return OutFactory.create(Meta.ErrorParam);
        }

        return userService.loginUser(username, password);
    }


}
