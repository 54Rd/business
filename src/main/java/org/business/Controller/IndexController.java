package org.business.Controller;

import org.business.Common.Out.Out;
import org.business.Service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangz on 2016/12/6.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping("/out")
    public Out getOut(){
        return indexService.getOut();
    }

    @RequestMapping("/outdata")
    public Out getOutData(){
        return indexService.getOutData();
    }


}
