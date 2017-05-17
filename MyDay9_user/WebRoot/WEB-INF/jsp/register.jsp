<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
    	用户名：<input type="text" name="username" value="${form.username }"/><span>${form.errors.username }</span><br/>
    	重复密码：<input type="password" name="password" value="${form.password }"/><span>${form.errors.password }</span><br/>
    	确认密码：<input type="password" name="password2" value="${form.password2 }"/><span>${form.errors.password2 }</span><br/>
    	生日：<input type="text" name="birthday" value="${form.birthday }"/><span>${form.errors.birthday }</span><br/>
    	电子邮箱:<input type="text" name="email" value="${form.email }"/><span>${form.errors.email }</span><br/>
    	昵称:<input type="text" name="nickname" value="${form.nickname }"/><span>${form.errors.nickname }</span><br/>
    	<input type="submit" name="注册"/>
    </form>
  </body>
</html>
