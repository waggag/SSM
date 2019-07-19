<%--
  User: waggag
  Date: 2019/7/18
  Time: 16:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>
    <h3>QuickStart</h3>
    <a href="hello">QuickStart</a>
    <a href="params/testParam?username=waggag">请求参数绑定</a>

    <form method="get" action="params/saveUser">
        姓名<input type="text" name="username" /><br>
        密码<input type="password" name="password"><br>
        <input type="submit" value="提交">
    </form>

    <%--常用的注解--%>
    <a href="anno/testRequestParam?username=waggag">RequestParams注解</a>
</body>
</html>
