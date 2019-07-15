package cn.waggag.mybatis.cfg;

/**
 * @description:用于封装执行的Sql语句和结果类型的全限定名
 * @author: waggag
 * @time: 2019/7/15 11:20
 * @Company http://www.waggag.cn
 */
public class Mapper {

    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
