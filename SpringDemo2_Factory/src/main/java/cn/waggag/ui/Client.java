package cn.waggag.ui;

import cn.waggag.factory.BeanFactory;
import cn.waggag.service.AccountService;
import cn.waggag.service.impl.AccountServiceImpl;

/**
 * @description: ui层调用业务层
 * @author: waggag
 * @time: 2019/7/16 22:20
 * @Company http://www.wagga g.cn
 */
public class Client {
    public static void main(String[] args) {
        //使用new创建对象,耦合严重
        //AccountService accountService = new AccountServiceImpl();
        //使用BeanFactory解耦
        for (int i = 0; i < 5; i++) {
            AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
           // accountService.addAccount();
            System.out.println(accountService);
        }
    }
}
