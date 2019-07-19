package cn.waggag.service;

import cn.waggag.domain.Account;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 10:46
 * @Company http://www.waggag.cn
 */
public interface AccountService {

    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    void addAccount(Account account);
}
