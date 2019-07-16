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
     * 查询所有操作
     */
    List<Account> findAll();


}
