<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ecnu.domain.Person"%>
<%@page import="com.ecnu.domain.Address"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>使用JSTL+el完成集合迭代</title>


  </head>
  
  <body>
	 <br/>
	 <%
	 	List list = new ArrayList();
	 	list.add(new Person("aaaaa"));
	 	list.add(new Person("bbbbb"));
	 	list.add(new Person("ccccc"));
	 	
	 	request.setAttribute("list",list);
	  %>
	<c:forEach var="person" items="${list}">
		${person.name }<br/>
	</c:forEach>
	
	<br/>
	 <%
	 	Map map = new HashMap();
	 	map.put("aa",new Person("aaaaa"));
	 	map.put("bb",new Person("bbbbb"));
	 	map.put("cc",new Person("ccccc"));
	 	
	 	request.setAttribute("map",map);
	  %>
	<c:forEach var="entry" items="${map}">
		${entry.key } : ${entry.value.name }<br/>
	</c:forEach>
	
	//代表用户登录了
	<c:if test="${user!=null}">
		欢迎您: ${user.username }
	</c:if>
	
	<c:if test="${user==null}">
		用户名：<input type="text"/>
		密码：<input type="text"/>
	</c:if>
  </body>
</html>
