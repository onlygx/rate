package com.elangzhi.rate.controller.rate;

import com.elangzhi.rate.controller.BaseController;
import com.elangzhi.rate.controller.tip.Tip;
import com.elangzhi.rate.model.CycleRate;
import com.elangzhi.rate.services.CycleRateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by GaoXiang on 2015/12/29 0029.
 */
@Controller
@RequestMapping("/rate")
public class RateController extends BaseController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Tip save(
            @RequestParam(value="rate", required=false) Integer rate,
            @RequestParam(value="appId", required=false) String appId,
            @RequestParam(value="time", required=false) Long time
    ){
        /*CycleRate cr = cycleRateService.findByDate(time);
        if(cr != null) return ERROR_2;*/
        try {
            Long id = cycleRateService.insertSelective(new CycleRate(time,rate,appId));
        }catch (Exception e){
            return ERROR_1;
        }
        return SUCCESS;
    }


    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @ResponseBody
    public Tip history(
            @RequestParam(value="rate", required=false) String rate,
            @RequestParam(value="appId", required=false) String appId,
            @RequestParam(value="time", required=false) String time
    ){

        try {
            cycleRateService.saveAll(rate,time,appId);
        }catch (Exception e){
            return ERROR_1;
        }
        return SUCCESS;
    }

    @RequestMapping("/show/{appId}")
    public ModelAndView showCall(@PathVariable String appId,
                                 @RequestParam(value="begin", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date begin,
                                 @RequestParam(value="end", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,

                                 HttpServletRequest request, ModelMap model){

        List<CycleRate> crList = cycleRateService.list(appId,begin,end);
        Long tempTime = 1l;
        for(int i = 0 ; i < crList.size(); i ++){
            if((crList.get(i).getTime().getTime() - tempTime) > 10000 && i != 0){
                CycleRate r = new CycleRate(tempTime+1000,null,null);
                crList.add(i,r);
                i++;
            }
            tempTime = crList.get(i).getTime().getTime();
        }
        model.put("list",crList);
        model.put("begin",begin);
        model.put("end",end);
        model.put("appId",appId);
        return new ModelAndView("rate-show",model);
    }

    //-------------------------- Service -----------------------

    @Resource
    private CycleRateService cycleRateService;
}
