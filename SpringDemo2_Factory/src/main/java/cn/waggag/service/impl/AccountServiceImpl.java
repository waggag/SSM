package cn.waggag.service.impl;

import cn.waggag.dao.AccountDao;
import cn.waggag.dao.impl.AccountDaoImpl;
import cn.waggag.factory.BeanFactory;
import cn.waggag.service.AccountService;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 22:12
 * @Company http://www.waggag.cn
 */
public class AccountServiceImpl implements AccountService {
    //程序耦合,需要避免使用new一个对象
    //private AccountDao accountDao = new AccountDaoImpl();
    //使用BeanFactory解耦
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    @Override
    public void addAccount() {
        accountDao.addAccount();
    }
}
