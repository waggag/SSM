package cn.waggag.mybatis.session;

import cn.waggag.mapper.UserMapper;

/**
 * @description: 可以创建Mapper的代理对象
 * @author: waggag
 * @time: 2019/7/15 11:05
 * @Company http://www.waggag.cn
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param userMapperClass Mapper的字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> userMapperClass);

    /**
     * 释放资源
     */
    void close();
}
