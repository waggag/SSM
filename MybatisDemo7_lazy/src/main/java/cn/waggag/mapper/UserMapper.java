package cn.waggag.mapper;

import cn.waggag.domain.User;

import java.util.List;

/**
 * @description:用户的持久层接口
 * @author: waggag
 * @time: 2019/7/15 0:18
 * @Company http://www.waggag.cn
 */
public interface UserMapper {
    /**
     * 查询所有操作
     */
    List<User> findAll();


    /**
     * 根据Id查询用户信息
     * @return
     */
    List<User> findById(Integer id);
}
