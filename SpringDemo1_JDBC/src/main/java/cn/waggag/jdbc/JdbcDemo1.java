package cn.waggag.jdbc;

import java.sql.*;

/**
 * @description: 程序的耦合  程序间的依赖关系
 *                         包括：
 *                              类之间的依赖关系
 *                              方法间的依赖关系
 *                          解耦：
 *                              降低程序之间的耦合
 *                         实际开发中应该做到编译期不依赖，运行期依赖
 *                  解耦的思想:
 *                      1.创建驱动的时候使用反射来创建带向,避免使用关键字
 *                      2.通过读取配置文件来获取要创建对象的全限定名
 * @author: waggag
 * @time: 2019/7/16 21:44
 * @Company http://www.waggag.cn
 */
public class JdbcDemo1 {
    public static void main(String[] args) {
        try {
            //1.1注册驱动
            //程序依赖于Driver类
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //1.2 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC",
                    "waggag", "225514");
            //3.获取操作数据库的预处理连接
            PreparedStatement prepareStatement = connection.prepareStatement("select * from account1");
            //4.执行Sql,得到结果集
            ResultSet resultSet = prepareStatement.executeQuery();
            //5.遍历结果集
           while(resultSet.next()){
               System.out.println(resultSet.getString("name"));
           }
            //6.释放资源
            resultSet.close();
           prepareStatement.close();
           connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
