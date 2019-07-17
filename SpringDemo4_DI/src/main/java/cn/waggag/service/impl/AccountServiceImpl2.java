package cn.waggag.service.impl;
import cn.waggag.service.AccountService;

import java.util.Date;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 22:12
 * @Company http://www.waggag.cn
 */
public class AccountServiceImpl2 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void addAccount() {
        System.out.println("Service的方法执行了");
    }
}
