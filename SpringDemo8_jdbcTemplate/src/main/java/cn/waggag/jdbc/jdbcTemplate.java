package cn.waggag.jdbc;

import cn.waggag.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @description: JDBCTemplate的基本用法
 * @author: waggag
 * @time: 2019/7/18 2:15
 * @Company http://www.waggag.cn
 */
public class jdbcTemplate {

    public static void main(String[] args) {
        //准备数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        dataSource.setUsername("waggag");
        dataSource.setPassword("225514");
        //1.创建对象
        JdbcTemplate template = new JdbcTemplate(dataSource);
        //2.执行SQl
        List<Account> accountList = template.query("select * from account1", new BeanPropertyRowMapper<>(Account.class));
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}
