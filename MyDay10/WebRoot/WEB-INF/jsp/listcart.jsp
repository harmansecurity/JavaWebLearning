<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>购物车列表</title>
    
    <script type="text/javascript">
    	function deleteitem(id){
    		var b = window.confirm("你确认删除嘛啊？");
    		if(b){
    			window.location.href="${pageContext.request.contextPath }/servlet/DeleteItemServlet?id="+id;
    		}
    	}
    	function clearcart(){
    		var b = window.confirm("你确认清空嘛啊？");
    		if(b){
    			window.location.href="${pageContext.request.contextPath }/servlet/ClearCartServlet";
    		}    	
    	}
    	function changeQuantity(input,id,oldvalue){
    		var quantity = input.value;//得到要修改的数量
    		//检查用户输入的数量是不是一个数字
    		if(isNaN(quantity)){
    			alert("请输入数字！");
    			input.value = oldvalue;
    			return;
    		}
    		//检查用户输入的数量是不是一个正整数
    		if(quantity<0 || quantity!=parseInt(quantity)){
    			alert("请输入一个正整数！");
    			input.value = oldvalue;
    			return;
    		}
    		
    		var b = window.confirm("您确认把书的数量修改为："+quantity+"...."+id);
    		if(b){
    			window.location.href="${pageContext.request.contextPath }/servlet/ChangeQuantityServlet?id="+id+"&quantity="+quantity;
    		}
    	}
    </script>
  </head>
  
  <body style="text-align:center">
    <h1>购物车列表</h1>
    <c:if test="${empty(cart.map)}">
    	您没有购买任何商品！
    </c:if>
    <c:if test="${!empty(cart.map)}">
    <table width="70%" border="1" style="text-align:center">
    	<tr>
    		<td>书名</td>
    		<td>作者</td>
    		<td>单价</td>
    		<td>数量</td>
    		<td>小计</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach var="entry" items="${cart.map}">
          <tr>
    		<td>${entry.value.book.name }</td>
    		<td>${entry.value.book.author }</td>
    		<td>${entry.value.book.price }</td>
    		<td>
    			<input type="text" name="quantity" value="${entry.value.quantity }" style="width:50px" onchange="changeQuantity(this,${entry.key},${entry.value.quantity })"/>
    		</td>
    		<td>${entry.value.price }</td>
    		<td>
    			<a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a><!-- 去掉超链接默认行为 -->
    		</td>
    	 </tr>
    	</c:forEach>
    	
        <tr>
    		<td colspan="3">总价</td>
    		<td colspan="2">${cart.price }元</td>
    		<td colspan="1">
    			<a href="javascript:void(0)" onclick="clearcart()">清空购物车</a>
    		</td>
    	</tr>
    </table>
    </c:if>
  </body>
</html>
