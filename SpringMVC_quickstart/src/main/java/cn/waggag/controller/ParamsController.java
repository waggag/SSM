package cn.waggag.controller;

import cn.waggag.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 请求参数绑定
 * @author: waggag
 * @time: 2019/7/18 18:01
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("珍惜你过了"+username);
        return "success";
    }

    /**
     * 请求参数绑定，把数据封装到一个请求参数的类中
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("珍惜你过了"+user);
        return "success";
    }
}
