package cn.waggag.factory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * @description: 一个创建Bena对象的工厂
 *              Bean: 在计算机英语中1有可重用组件的含义
 *                 JavaBean: 不等于实体类,实体类只是可重用组件的一部分
 *            创建Service和Dao对象的
 *              1.创建驱动的时候使用反射来创建带向,避免使用关键字
 *                      配置的内容:
 *                          唯一标识=全限定类名(key=value)
 *  *           2.通过读取配置文件来获取要创建对象的全限定名,通过反射创建类
 * @author: waggag
 * @time: 2019/7/16 22:24
 * @Company http://www.waggag.cn
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties properties;
    //定义一个容器,存放我们要创建的对象
    private static Map<String,Object> beans;

    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取properties文件的流对象,使用类加载器获取文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
            //实例化容器
            beans = new HashMap<>();
           //取出配置文件中所有的Key
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key =  keys.nextElement().toString();
                beans.put(key,Class.forName(properties.getProperty(key)).newInstance());
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化Bena.properties文件失败");
        }
    }

    /**
     * 根据Bean的名称获取对象
     * @param baneName
     * @return
     */
    public static Object getBean(String baneName) {
        return beans.get(baneName);
    }
}
