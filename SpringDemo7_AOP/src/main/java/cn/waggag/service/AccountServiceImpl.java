package cn.waggag.service;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/18 0:19
 * @Company http://www.waggag.cn
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void addAccount() {
        System.out.println("add");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("update");
    }

    @Override
    public int deleteAccount() {
        System.out.println("delete");
        return 0;
    }
}
