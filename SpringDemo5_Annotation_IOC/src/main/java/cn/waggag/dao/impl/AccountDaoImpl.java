package cn.waggag.dao.impl;

import cn.waggag.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @description: 账户的持久层实现类
 * @author: waggag
 * @time: 2019/7/16 22:14
 * @Company http://www.waggag.cn
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void addAccount() {
        System.out.println("保存账户");
    }
}
