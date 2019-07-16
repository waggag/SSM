package cn.waggag;

import cn.waggag.domain.Account;
import cn.waggag.domain.User;
import cn.waggag.mapper.AccountMapper;
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
 * @description: mybatis的入门
 * @author: waggag
 * @time: 2019/7/15 0:43
 * @Company http://www.waggag.cn
 */
public class UserTest {
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
        sqlSession = sqlSessionFactory.openSession();
        //4.获取Mapper的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //6.关闭资源
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user.getAccountList());
        }
    }

    /**
     * 测试查询用户的所有角色
     */
    @Test
    public void testFindRoleAll(){
        List<User> userList = userMapper.findRoleAll();
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user.getRoleList());
        }
    }
}
