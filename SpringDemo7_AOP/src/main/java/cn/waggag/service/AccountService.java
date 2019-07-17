package cn.waggag.service;

/**
 * @description:业务层的接口
 * @author: waggag
 * @time: 2019/7/18 0:16
 * @Company http://www.waggag.cn
 */
public interface AccountService {

    /**
     * 模拟添加账户
     */
    void addAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     */
    int  deleteAccount();

}
