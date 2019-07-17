package cn.waggag.jdbc;

import cn.waggag.utils.JdbcDataSourceUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 王港
 * @Date: 2019/6/1 1:15
 * @version: 1.0
 */
public class DruidDemo2 {

    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        DataSource dataSource = JdbcDataSourceUtils.getDataSource();
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
