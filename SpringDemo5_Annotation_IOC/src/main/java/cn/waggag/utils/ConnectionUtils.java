package cn.waggag.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 账户的持久层
 * @author: waggag
 * @time: 2019/7/17 19:06
 * @Company http://www.waggag.cn
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal上获取
            Connection connection = threadLocal.get();
            //2.判断当前线程是否有连接
            if(connection == null){
                //3.从数据源获取一个链接并且存入当前线程中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }


    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
