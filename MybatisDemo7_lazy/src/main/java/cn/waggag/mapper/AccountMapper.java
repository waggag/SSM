package cn.waggag.mapper;

import cn.waggag.domain.Account;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 9:26
 * @Company http://www.waggag.cn
 */
public interface AccountMapper {

    /**
     * 查询所有账户，并获取账户所属用户的信息
     */
    List<Account> findAll();

    /**
     * 根据UId查询账户
     * @param uid
     * @return
     */
    List<Account> findAccountById(Integer uid);


}
