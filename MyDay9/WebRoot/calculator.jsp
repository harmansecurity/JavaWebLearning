<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>计算器</title>


  </head>
  
  <body style="text-align: center;">
  
  <jsp:useBean id="calculatorBean" class="com.ecnu.domain.CalculatorBean"></jsp:useBean>
  <jsp:setProperty  name="calculatorBean" property="*"/>
  <%
  	try{
  		calculatorBean.calculate();
  	}catch(Exception e){
  		out.write(e.getMessage());
  	}
   %>
   
   <br>------------------------------------------------<br/>
       计算结果是：
   <jsp:getProperty name="calculatorBean" property="firstNum" />
   <jsp:getProperty name="calculatorBean" property="operator" />
   <jsp:getProperty name="calculatorBean" property="secondNum" />
   =
   <jsp:getProperty name="calculatorBean" property="result" />
   <br>------------------------------------------------<br/>   
   
   
   
  <form action="/MyDay9/calculator.jsp" method="post">
	<table width="40%" border="1">
		<tr>
			<td colspan="2">简单的计算器</td>
		</tr>
		<tr>
			<td>第一个参数</td>
			<td>
				<input type="text" name="firstNum">
			</td>
		</tr>
		<tr>
			<td>操作符</td>
			<td>
				<select name="operator">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="*">*</option>
					<option value="/">/</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>第二个参数</td>
			<td>
				<input type="text" name="secondNum">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="计算"/>
			</td>
		</tr>						
	</table>
  </form>
  </body>
</html>
