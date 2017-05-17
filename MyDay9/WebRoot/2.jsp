<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>jsp:setProperty标签</title>


  </head>
  
  <body>
    <jsp:useBean id="person" class="com.ecnu.domain.Person" scope="page"/>
	<!-- 手工为bean属性赋值 -->
	<jsp:setProperty property="name" name="person" value="wangjun"/>
    <%=person.getName()%><br/>
    
    <!-- 用请求参数给bean的属性赋值 -->
    <jsp:setProperty property="name" name="person" param="name"/>
    <!-- http://harmansecurity:8080/MyDay9/2.jsp?name=ewrqwerqwerqw&&age=123 -->
    <jsp:setProperty property="age" name="person" param="age"/><!-- 支持八种数据类型的转换 -->
    <!-- harmansecurity:8080/MyDay9/2.jsp?name=ewrqwerqwerqw&&age=123&&birthday=1980-08-09 -->
    <jsp:setProperty property="birthday" name="person" value="<%=new Date() %>"/>
    <%=person.getName()%><br/>
    <%=person.getAge()%><br/>
    <%=person.getBirthday()%><br/>
    
    <br>------------------------------------------------<br>
    
    <!-- 用所有的请求参数为bean赋值 -->
    <jsp:setProperty name="person" property="*"/>
    <%=person.getName()%><br/>
    <%=person.getAge()%><br/>
    
    <jsp:getProperty name="person" property="age"/>
  </body>
</html>
