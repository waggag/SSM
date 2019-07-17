package cn.waggag.jdbc;

import cn.waggag.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 王港
 * @Date: 2019/5/31 22:04
 * @version: 1.0
 */
public class JdbcDemo2 {
    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        //4.定义sql语句
        String sql = "insert into oracle_user(username) values('wagag')";
        //5.获取执行sql的对象
        Statement statement = connection.createStatement();
        //6.执行sql
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        //7.释放资源
        statement.close();
        connection.close();
    }
}
