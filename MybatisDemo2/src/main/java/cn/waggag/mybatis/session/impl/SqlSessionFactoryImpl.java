package cn.waggag.mybatis.session.impl;

import cn.waggag.mybatis.cfg.Configuration;
import cn.waggag.mybatis.session.SqlSession;
import cn.waggag.mybatis.session.SqlSessionFactory;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 12:37
 * @Company http://www.waggag.cn
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration configuration;

    public SqlSessionFactoryImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(configuration);
    }
}
