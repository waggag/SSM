package cn.waggag.test;

import cn.waggag.domain.User;
import cn.waggag.domain.User1;
import cn.waggag.mapper.User1Mapper;
import cn.waggag.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: UserMapper的测试
 * @author: waggag
 * @time: 2019/7/16 15:27
 * @Company http://www.waggag.cn
 */
public class User1Test {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private User1Mapper mapper;


    @Before
    public void init() throws IOException {
        //1.获取字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取Session
        sqlSession = sqlSessionFactory.openSession();
        //4.获取代理对象
        mapper = sqlSession.getMapper(User1Mapper.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }


    /**
     * 测试查询所有用户
     */
    @Test
    public  void testFindAll() {
        //5.调用代理方法
        List<User1> userList = mapper.findAll();
        for (User1 user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public  void testFindByName() {
        List<User1> userList = mapper.findByName("%w%");
        for (User1 user : userList) {
            System.out.println(user);
        }
    }


}
