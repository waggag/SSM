<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="cn.waggag.mapper.UserMapper" %>
<%@ page import="cn.waggag.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1.读取配置文件
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    //2.创建一个SqlSessionFactory工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
    //3.使用工厂生成SqlSession对象
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //4.使用SqlSession创建Dao接口的代理对象
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    //5.使用代理对象执行方法
    List<User> userList = mapper.findAll();
    for (User user : userList) {
    System.out.println(user);
    }
    //6.释放资源
    sqlSession.close();
    inputStream.close();
%>
</body>
</html>
