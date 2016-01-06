package com.elangzhi.rate.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GaoXiang on 2015/10/22 0022.
 */

@Controller
@RequestMapping("/web")
public class AppController {


    @RequestMapping("/allow_user")
    @ResponseBody
    public Integer allowApp(){
            //0 表示允许
            //1 表示不允许
            Integer ret = 0;
        return ret;
    }


}
