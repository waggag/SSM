package cn.waggag.service.impl;
import cn.waggag.service.AccountService;

import java.util.Date;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 22:12
 * @Company http://www.waggag.cn
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void addAccount() {
        System.out.println("Service的方法执行了");
    }
}
