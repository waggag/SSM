package cn.waggag.mapper;

import cn.waggag.domain.User;
import cn.waggag.mybatis.annotations.Select;

import java.util.List;

/**
 * @description:用户的持久层接口
 * @author: waggag
 * @time: 2019/7/15 0:18
 * @Company http://www.waggag.cn
 */
public interface UserMapper1 {
    /**
     * 查询所有操作
     */
    @Select("select * from user;")
    List<User> findAll();
}
