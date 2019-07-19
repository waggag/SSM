package cn.waggag.exception;

/**
 * @description: 自定义系统异常类
 * @author: waggag
 * @time: 2019/7/19 9:22
 * @Company http://www.waggag.cn
 */
public class SysException extends Exception {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SysException(String msg) {
        this.msg = msg;
    }
}
