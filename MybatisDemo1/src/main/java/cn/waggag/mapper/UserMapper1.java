package cn.waggag.mapper;
import cn.waggag.domain.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * @description:
 * @author: waggag
 * @time: 2019/7/15 10:03
 * @Company http://www.waggag.cn
 */
public interface UserMapper1 {

    /**
     * 查询所有操作
     */
    @Select("select * from user")
    List<User> findAll();

}
