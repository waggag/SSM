package cn.waggag.mybatis.session;

import cn.waggag.mybatis.cfg.Configuration;
import cn.waggag.mybatis.session.impl.SqlSessionFactoryImpl;
import cn.waggag.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @description: 用于创建一个SqlSessionFactory对象
 * @author: waggag
 * @time: 2019/7/15 11:03
 * @Company http://www.waggag.cn
 */
public class SqlSessionFactoryBuilder  {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){

        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new SqlSessionFactoryImpl(configuration);
    }
}
