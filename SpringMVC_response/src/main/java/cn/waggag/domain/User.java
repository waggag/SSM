package cn.waggag.domain;

import java.io.Serializable;

/**
 * @description: 用户的实体类
 * @author: waggag
 * @time: 2019/7/18 23:11
 * @Company http://www.waggag.cn
 */
public class User implements Serializable {

    private String username;
    private String password;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
