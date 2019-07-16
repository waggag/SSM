package cn.waggag.mapper;

import cn.waggag.domain.User;
import cn.waggag.domain.User1;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @description: 用户的Mapper
 * @author: waggag
 * @time: 2019/7/16 15:20
 * @Company http://www.waggag.cn
 * @Select @Insert @Update @Delete
 */
public interface User3Mapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                many = @Many(select = "cn.waggag.mapper.AccountMapper.findAccountByUid",
                        fetchType = FetchType.DEFAULT))
    })
    List<User1> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap("userMap")
    User1 findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<User1> findUserByName(String username);

}
