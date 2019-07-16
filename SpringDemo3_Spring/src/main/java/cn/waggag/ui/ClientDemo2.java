package cn.waggag.ui;
import cn.waggag.dao.AccountDao;
import cn.waggag.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description: ui层调用业务层
 * @author: waggag
 * @time: 2019/7/16 22:20
 * @Company http://www.wagga g.cn
 */
public class ClientDemo2 {

    public static void main(String[] args) {
        //1.获取Spring核心容器,Application获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);

    }
}
