<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>pageContext访问其他域</title>
    
  </head>
  
  <body>
	<%
		request.setAttribute("data","23412");
		String data = (String)pageContext.getAttribute("data",PageContext.REQUEST_SCOPE);
		out.write(data);
		pageContext.findAttribute("data");//page request session application
	 %>    
  </body>
</html>
