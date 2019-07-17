package cn.waggag.cglib;

import cn.waggag.proxy.IProducer;

/**
 * @description：生产者
 * @author: waggag
 * @time: 2019/7/17 21:09
 * @Company http://www.waggag.cn
 */
public class Producer{

    public void saleProduct(float money){
        System.out.println("销售producer,拿到钱"+money);
    }

    public void afterService(){
        System.out.println("提供售后");
    }
}
