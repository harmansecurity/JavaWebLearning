<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Jsp常用标签</title>
    
  </head>
  
  <body>
	<jsp:forward page="/index.jsp">
		<jsp:param name="username" value="xxxxx"/>
	</jsp:forward>  
  </body>
</html>
