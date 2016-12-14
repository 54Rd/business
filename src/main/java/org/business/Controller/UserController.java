package org.business.Controller;

import org.business.Bean.Out;
import org.business.Bean.UserProfile;
import org.business.Common.BaseController;
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

        System.out.println(name+password+realname);
        if (StringUtils.anyEmpty(name, password, realname))
            return writeJsonFail("参数不全");

        int count = userService.findCountByUserName(name);
        if(count>0)
            return writeJsonFail("已被注册");

        boolean isDone = userService.createUser(name,realname,password);
        return isDone?writeJsonSuccess("创建成功",null):writeJsonFail();
    }
}
