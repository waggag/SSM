package cn.waggag.test;

import cn.waggag.dao.AccountDao;
import cn.waggag.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 11:52
 * @Company http://www.waggag.cn
 */
public class testMybatis {

    @Test
    public void run() throws Exception {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        Account account = new Account();
        account.setName("waggag");
        account.setMoney(10000);
        accountDao.addAccount(account);
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
