package cn.waggag.test;

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
 * @description: AccountMapper的测试
 * @author: waggag
 * @time: 2019/7/16 15:27
 * @Company http://www.waggag.cn
 */
public class AccountTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AccountMapper mapper;


    @Before
    public void init() throws IOException {
        //1.获取字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取Session
        sqlSession = sqlSessionFactory.openSession();
        //4.获取代理对象
        mapper = sqlSession.getMapper(AccountMapper.class);
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
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    /**
     * 测试查询所有用户
     */
    @Test
    public  void testFindAccountByUid() {
        List<Account> accountList = mapper.findAccountByUid(46);
        System.out.println(accountList);
    }

}
