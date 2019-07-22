<%--
  User: waggag
  Date: 2019/7/19
  Time: 0:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>传统方式上传文件</h1>
    <form action="/user/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="文件上传">
    </form>
    <h1>SpringMVC上传文件</h1><br>
    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="文件上传">
    </form>

    <h1>跨服务器上传文件</h1><br>
    <form action="/user/fileupload2" method="post" enctype="multipart/form-data">
        <input type="file" name="upload">
        <input type="submit" value="文件上传">
    </form>


</body>
</html>
