package cn.waggag.mybatis.io;

import java.io.InputStream;

/**
 * @description:使用类加载器读取配置文件
 * @author: waggag
 * @time: 2019/7/15 10:58
 * @Company http://www.waggag.cn
 */
public class Resources {

    /**
     * 使用类加载器读取配置文件,根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){

        return Resources.class.getClassLoader().getResourceAsStream(filePath);

    }

}
