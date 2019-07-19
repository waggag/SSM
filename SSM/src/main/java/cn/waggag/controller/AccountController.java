package cn.waggag.controller;

import cn.waggag.domain.Account;
import cn.waggag.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description: 控制器
 * @author: waggag
 * @time: 2019/7/19 10:48
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/testSpringMVC")
    public String testSpringMVC(){
        System.out.println("testSpringMVC");
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        return "list";
    }
}
