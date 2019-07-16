package cn.waggag.test;

import cn.waggag.domain.User;
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
public class UserTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper mapper;


    @Before
    public void init() throws IOException {
        //1.获取字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取Session
        sqlSession = sqlSessionFactory.openSession();
        //4.获取代理对象
        mapper = sqlSession.getMapper(UserMapper.class);
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
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试添加用户
     */
    @Test
    public  void testAddUser() {
        User user = new User();
        user.setUsername("waggag");
        user.setAddress("北京");
        user.setSex("男");
        mapper.addUser(user);
    }

    /**
     * 测试添加用户
     */
    @Test
    public  void testUpadteUser() {
        User user = new User();
        user.setUsername("waggag");
        user.setAddress("天津");
        user.setSex("男");
        mapper.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public  void testDeleteUser() {
        mapper.deleteUser(52);
    }

    @Test
    public  void testFindByName() {
        List<User> userList = mapper.findByName("%w%");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne(){
        User user = mapper.findById(46);
        System.out.println(user);
    }


}
