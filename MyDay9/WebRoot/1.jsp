<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>jsp:usebean标签的使用</title>


  </head>
  
  <body>
    <jsp:useBean id="person" class="com.ecnu.domain.Person" scope="page"></jsp:useBean>
    <%=person.getName()%>
  </body>
</html>
