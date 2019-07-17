package cn.waggag.service.impl;
import cn.waggag.service.AccountService;

import java.util.*;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 22:12
 * @Company http://www.waggag.cn
 */
public class AccountServiceImpl3 implements AccountService {

    private String[] strings;
    private List<String> stringList;
    private Set<String> stringSet;
    private Map<String,String > stringMap;
    private Properties properties;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl3{" +
                "strings=" + Arrays.toString(strings) +
                ", stringList=" + stringList +
                ", stringSet=" + stringSet +
                ", stringMap=" + stringMap +
                ", properties=" + properties +
                '}';
    }

    @Override
    public void addAccount() {
        System.out.println("Service的方法执行了"+this.toString());

    }
}
