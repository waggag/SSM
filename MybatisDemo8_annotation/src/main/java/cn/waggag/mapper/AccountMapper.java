package cn.waggag.mapper;

import cn.waggag.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 16:39
 * @Company http://www.waggag.cn
 */
public interface AccountMapper {

    /**
     * 查询账户和用户
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",
                    one=@One(select="cn.waggag.mapper.UserMapper.findById",fetchType= FetchType.DEFAULT))
    })
    List<Account> findAll();

    /**
     * 根据用户Id查询账户信息
     */

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountByUid(Integer uid);

}
