package cn.waggag.service.impl;

import cn.waggag.dao.AccountDao;
import cn.waggag.domain.Account;
import cn.waggag.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/19 10:47
 * @Company http://www.waggag.cn
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service findALl");
        return accountDao.findAll();
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("Service addAccount");
        accountDao.addAccount(account);
    }
}
