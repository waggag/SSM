package cn.waggag.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 异常处理的类
 * @author: waggag
 * @time: 2019/7/19 9:27
 * @Company http://www.waggag.cn
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常的逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常
        SysException exception = null;
        if(e instanceof SysException){
            exception = (SysException)e;
        }else {
            exception = new SysException("系统正在维护");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",exception.getMsg());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
