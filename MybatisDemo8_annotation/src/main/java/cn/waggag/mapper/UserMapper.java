package cn.waggag.mapper;

import cn.waggag.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description: 用户的Mapper
 * @author: waggag
 * @time: 2019/7/16 15:20
 * @Company http://www.waggag.cn
 * @Select @Insert @Update @Delete
 */
public interface UserMapper {

    /**
     * @return 用户列表
     */
    @Select("select * from user;")
    List<User> findAll();

    /**
     * 添加一个用户
     *
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday});")
    void addUser(User user);

    /**
     * 更新一个用户
     *
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id = #{id}")
    void updateUser(User user);

    /**
     * 根据用户Id删除用户
     * @param user_id
     */
    @Delete("delete from user where id = #{id};")
    void deleteUser(Integer user_id);

    /**
     * 根据用户姓名的模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username};")
    List<User> findByName(String username);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);


}
