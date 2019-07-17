package cn.waggag.ui;

import cn.waggag.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: ui层调用业务层
 * @author: waggag
 * @time: 2019/7/16 22:20
 * @Company http://www.wagga g.cn
 */
public class Client {

    public static void main(String[] args) {
        //1.获取Spring核心容器,Application获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.addAccount();

        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService2 = (AccountService)applicationContext2.getBean("accountService2");
        accountService2.addAccount();

        ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService3 = (AccountService)applicationContext3.getBean("accountService3");
        accountService3.addAccount();
    }
}
