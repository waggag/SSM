package cn.waggag.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
/**
 * 把字符串转换成日期的转换器
 * @author rt
 */
public class StringToDateConverter implements Converter<String, Date>{
    /**
     * 进行类型转换的方法
     */
    public Date convert(String source) {
        if(source == null) {
            throw new RuntimeException("参数不能为空");
        }
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("类型转换错误");
        }
    }
}