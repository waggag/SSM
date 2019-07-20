package cn.waggag.test;

import cn.waggag.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 10:54
 * @Company http://www.waggag.cn
 */
public class testSpring {
    @Test
    public  void testSpring(){
        //1.加载Spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取对象
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        //3.调用方法
        accountService.findAll();
    }

}
