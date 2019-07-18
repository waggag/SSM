package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 王港
 * @Date: 2019/5/31 22:04
 * @version: 1.0
 */
public class JdbcDemo1 {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String oracle_Driver = "oracle.jdbc.OracleDriver";

    private static String mysql_url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
    private static String oracle_url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl.168.118.1";

    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName(oracle_Driver);
        //3.获取数据库连接对象
        Connection connection = DriverManager.getConnection(oracle_url, "waggag", "225514");
        //4.定义sql语句
        String sql = "insert into oracle_user(id,username) values('2','waggag')";
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
