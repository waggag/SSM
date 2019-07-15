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
import java.util.Date;
import java.util.List;

/**
 * @description: 测试mybatis的CRUD操作
 * @author: waggag
 * @time: 2019/7/15 16:28
 * @Company http://www.waggag.cn
 */
public class MybatisTestCRUD {

    private InputStream inputStream;
    private  SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SqlSession
        sqlSession = sqlSessionFactory.openSession(true);
        //4.获取Mapper的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        //6.关闭资源
        sqlSession.close();
        inputStream.close();
    }


    //测试查询所有
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试增加用户的方法
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("waggag");
        user.setAddress("河南");
        user.setBirthday(new Date());
        user.setSex("男");
        //5.调用代理对象的方法
        userMapper.addUser(user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(51);
        user.setUsername("ms");
        user.setAddress("河南");
        user.setBirthday(new Date());
        user.setSex("女");
        //5.调用代理对象的方法
        userMapper.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() {
        //5.调用代理对象的方法
        userMapper.deleteUser(51);
    }

    /**
     * 根据Id查询用户信息
     */
    @Test
    public void testFindUserById() {
        //5.调用代理对象的方法
        User user = userMapper.findUserById(52);
        System.out.println(user);
    }

    /**
     * 测试用户名的模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> userList = userMapper.findByName("%w%");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试聚合函数的使用
     */
    @Test
    public void testFindTotal() {
        int total = userMapper.findTotal();
        System.out.println(total);
    }

}
