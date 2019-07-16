package cn.waggag.mybatis.proxy;

import cn.waggag.mybatis.utils.Executor;
import cn.waggag.mybatis.cfg.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 12:52
 * @Company http://www.waggag.cn
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers  = mappers;
        this.connection = connection;
    }


    /**
     * 用于对方法进行增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合Key
        String key = className+"."+methodName;
        //4.获取Mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有Mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.调用工具类查询所有
        return new Executor().selectList(mapper,connection);
    }
}
