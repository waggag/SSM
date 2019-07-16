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
public interface User1Mapper {

    /**
     * @return 用户列表
     */
    @Select("select * from user;")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
    })
    List<User1> findAll();


    @Select("select * from user where username like #{username};")
    @ResultMap("userMap")
    List<User1> findByName(String username);

}
