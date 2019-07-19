package cn.waggag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 控制器类
 * @author: waggag
 * @time: 2019/7/18 17:02
 * @Company http://www.waggag.cn
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("Hello MVC");
        return "success";
    }
}
