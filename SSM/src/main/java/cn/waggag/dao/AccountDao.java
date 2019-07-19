package cn.waggag.dao;

import cn.waggag.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 10:45
 * @Company http://www.waggag.cn
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    @Select("select * from account1;")
    List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    @Insert("insert into account1(id,name,money) values(#{id},#{name},#{money});")
    void addAccount(Account account);
}
