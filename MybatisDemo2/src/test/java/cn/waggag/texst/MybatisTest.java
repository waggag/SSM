package cn.waggag.texst;

import cn.waggag.domain.User;
import cn.waggag.mapper.UserMapper1;
import cn.waggag.mybatis.session.SqlSession;
import cn.waggag.mybatis.session.SqlSessionFactory;
import cn.waggag.mybatis.session.SqlSessionFactoryBuilder;
import cn.waggag.mybatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: mybatis的入门
 * @author: waggag
 * @time: 2019/7/15 0:43
 * @Company http://www.waggag.cn
 */
public class MybatisTest {
    /**
     * mybatis的入门
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建一个SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        //3.使用工厂生成SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        //5.使用代理对象执行方法
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
