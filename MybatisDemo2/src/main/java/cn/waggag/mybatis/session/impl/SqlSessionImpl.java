package cn.waggag.mybatis.session.impl;

import cn.waggag.mybatis.cfg.Configuration;
import cn.waggag.mybatis.proxy.MapperProxy;
import cn.waggag.mybatis.session.SqlSession;
import cn.waggag.mybatis.utils.DataUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:SqlSession的实现类
 * @author: waggag
 * @time: 2019/7/15 12:43
 * @Company http://www.waggag.cn
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public SqlSessionImpl(Configuration configuration) {
        this.configuration = configuration;
        this.connection = DataUtils.getConnection(configuration);
    }

    /**
     * 用于创建代理对象
     * @param userMapperClass Mapper的字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> userMapperClass) {
        T instance = (T) Proxy.newProxyInstance(userMapperClass.getClassLoader(), new Class[]{userMapperClass},
                new MapperProxy(configuration.getMappers(), connection));
        return instance;
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
