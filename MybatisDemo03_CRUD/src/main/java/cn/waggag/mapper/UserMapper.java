package cn.waggag.mapper;

import cn.waggag.domain.QueryVo;
import cn.waggag.domain.User;

import javax.management.Query;
import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 16:17
 * @Company http://www.waggag.cn
 */
public interface UserMapper {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 增加一个用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据Id删除用户
     * @param id 用户Id
     */
    void deleteUser(Integer id);

    /**
     * 根据Id查询用户信息
     * @param id 用户Id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 根据用户名模糊查询用户
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总的记录数
     * @return 总记录数
     */
    int findTotal();

    /**
     * 根据QueryVo中的查询条件查询用户
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

}
