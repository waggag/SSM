package cn.waggag.jdbcTemplate;

import cn.waggag.utils.JdbcDataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * jdbcTemplate的基本使用
 *
 * @author 王港
 * @Date: 2019/6/1 1:46
 * @version: 1.0
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getDataSource());
        //3.调用方法
        System.out.println(jdbcTemplate);
    }
}
