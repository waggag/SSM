package cn.waggag.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 * @author 王港
 * @Date: 2019/6/1 1:00
 * @version: 1.0
 */
public class C3P0Demo1 {

    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource dataSource = new ComboPooledDataSource();
        //2.获取连接对象
        Connection connection = dataSource.getConnection();
        //3.检查是否获取
        System.out.println(connection);
    }

}
