package cn.waggag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 常用的注解
 * @author: waggag
 * @time: 2019/7/18 20:41
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="username") String name){
        System.out.println("testRequestParam");
        System.out.println(name);
        return "success";
    }
}
