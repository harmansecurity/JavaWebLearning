<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>include指令(动态包含)</title>
    
  </head>
  
  <body>
      <%
      	request.getRequestDispatcher("/public/head.jsp").include(request,response);
      %>
      
              热污染群翁群无若群翁日期为<br>
     <%
      	request.getRequestDispatcher("/public/foot.jsp").include(request,response);
      %>          
  </body>
</html>
