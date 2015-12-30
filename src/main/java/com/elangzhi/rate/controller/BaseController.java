package com.elangzhi.rate.controller;

import com.elangzhi.rate.controller.tip.ErrorTip;
import com.elangzhi.rate.controller.tip.SuccessTip;
import com.elangzhi.rate.controller.tip.Tip;

/**
 * Created by GaoXiang on 2015/12/28 0028.
 */
public class BaseController {
    //session超时
    public  final Tip TIMEOUT = new ErrorTip(-1);
    //处理成功
    public  final Tip SUCCESS = new SuccessTip();
    //失败以及返回代码
    public  final Tip ERROR_1 = new ErrorTip(1);
    public  final Tip ERROR_2 = new ErrorTip(2);
    public  final Tip ERROR_3 = new ErrorTip(3);
    public  final Tip ERROR_4 = new ErrorTip(4);
    public  final Tip ERROR_5 = new ErrorTip(5);


}
