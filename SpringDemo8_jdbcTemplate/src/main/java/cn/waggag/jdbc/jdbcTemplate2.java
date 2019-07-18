package cn.waggag.jdbc;

import cn.waggag.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @description: JDBCTemplate的基本用法
 * @author: waggag
 * @time: 2019/7/18 2:15
 * @Company http://www.waggag.cn
 */
public class jdbcTemplate2 {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
       //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        //2.执行SQl
        List<Account> accountList = jdbcTemplate.query("select * from account1", new BeanPropertyRowMapper<>(Account.class));
        for (Account account : accountList) {
            System.out.println(account);
        }


    }
}
