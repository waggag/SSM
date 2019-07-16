package cn.waggag.ui;
import cn.waggag.dao.AccountDao;
import cn.waggag.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description: ui层调用业务层
 * @author: waggag
 * @time: 2019/7/16 22:20
 * @Company http://www.wagga g.cn
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     *
     * 核心容器的两个接口引发出的问题：
     *  ApplicationContext: 单例对象适用
     *      采用此接口它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。
     *      也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *
     *  BeanFactory: 多例对象使用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。
     *      也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {
        //1.获取Spring核心容器,Application获取对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "D:\\WorkSpace\\IntelliJIDEA\\SSM\\SpringDemo3_Spring\\src\\main\\resources\\bean.xml");
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);

        //2.BeanFactory获取对象
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        AccountService accountService1 = beanFactory.getBean("accountService", AccountService.class);
        System.out.println(accountService1);
    }
}
