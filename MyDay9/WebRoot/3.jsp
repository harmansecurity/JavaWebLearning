<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ecnu.domain.Person"%>
<%@page import="com.ecnu.domain.Address"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>EL表达式使用</title>


  </head>
  
  <body>
  	<%
		String data = "abcd";
		request.setAttribute("data",data);
	 %>
	 
	 ${data }<!-- pageContext.findAttribute() -->
	 
	 <%
	 	Person p = new Person();
	 	p.setName("524352");
	 	request.setAttribute("person",p);
	 %>
	 ${person.name }
	 
	 
	<%
	 	Person p1 = new Person();
	 	Address a = new Address();
	 	a.setCity("上海");
	 	p1.setAddress(a);
	 	request.setAttribute("p1",p1);
	 %>
	 ${p1.address.city }
	 
	 <br/>
	 <%
	 	List list = new ArrayList();
	 	list.add(new Person("aaaaa"));
	 	list.add(new Person("bbbbb"));
	 	list.add(new Person("ccccc"));
	 	
	 	request.setAttribute("list",list);
	  %>
	  ${list[0].name }
	  
	  	 <br/>
	 <%
	 	Map map = new HashMap();
	 	map.put("aa",new Person("aaaaa"));
	 	map.put("bb",new Person("bbbbb"));
	 	map.put("cc",new Person("ccccc"));
	 	
	 	request.setAttribute("map",map);
	  %>
	  ${map.aa.name}
	  ${map.bb.name}<!-- 用el表达式在取数据的时候，通常用.号，.号取不出来时用[] -->
	  
	  ${pageContext.request.contextPath }<!-- 得到当前web项目的名称 -->
	  
	  <a href="${pageContext.request.contextPath }/index.jsp">点点</a>
  </body>
</html>
