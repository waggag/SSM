package cn.waggag.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 13:59
 * @Company http://www.waggag.cn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置Sql语句的值
     * @return
     */
    String value();

}
