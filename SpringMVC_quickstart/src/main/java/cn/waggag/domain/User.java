package cn.waggag.domain;

import java.io.Serializable;

/**
 * @description: 用户实体类，测试JavaBean的参数绑定
 * @author: waggag
 * @time: 2019/7/18 18:07
 * @Company http://www.waggag.cn
 */
public class User implements Serializable {

    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
