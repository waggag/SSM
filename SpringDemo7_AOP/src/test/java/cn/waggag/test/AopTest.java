package cn.waggag.test;

import cn.waggag.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试AOP的配置
 * @author: waggag
 * @time: 2019/7/18 0:58
 * @Company http://www.waggag.cn
 */
public class AopTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        //3.执行方法
        accountService.addAccount();
        accountService.updateAccount(1);
        accountService.deleteAccount();



    }
}
