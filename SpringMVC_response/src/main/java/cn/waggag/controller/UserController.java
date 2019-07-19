package cn.waggag.controller;

import cn.waggag.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/18 23:08
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString");
        //模拟数据库查询的数据查询出User对象
        User user = new User();
        user.setUsername("waggag");
        user.setPassword("2255655");
        user.setAge(20);
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid");
        //1.请求转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //2.重定向
       // response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //3.直接进行响应
        response.getWriter().print("你好");
        return ;
    }



    @RequestMapping("/testModelAndView")
    public String testModelAndView(){
        //1.创建ModelANdView对象
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("testModelAndView");
        User user = new User();
        user.setUsername("waggag");
        user.setPassword("655");
        user.setAge(20);
        //2.把user存入到modelAndView对象中
        modelAndView.addObject("user",user);
        //跳转的页面
        modelAndView.setViewName("success");
        return "success";
    }

}
