package cn.waggag.mybatis.session;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 11:08
 * @Company http://www.waggag.cn
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的Session对象
     * @return
     */
    SqlSession openSession();
}
