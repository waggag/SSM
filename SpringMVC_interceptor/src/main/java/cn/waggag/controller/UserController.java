package cn.waggag.controller;

import cn.waggag.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 9:14
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException");
        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //向上抛出自定义异常信息
            throw new SysException("查询用户出啊闲了异常");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor() throws SysException {
        System.out.println("testInterceptor");
        return "success";
    }

}
