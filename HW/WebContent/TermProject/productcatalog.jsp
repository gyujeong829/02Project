<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "my.model.*, my.dao.*, java.sql.*, my.util.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>무제 문서</title>
<link href="second.css" rel="stylesheet" type="text/css" /><link href="https://fonts.googleapis.com/css?family=Mr+Dafoe|Sacramento|Tangerine" rel="stylesheet"><link href="https://fonts.googleapis.com/css?family=Yeon+Sung" rel="stylesheet">
<style type="text/css"><link href="main.css" rel="stylesheet" type="text/css" /><link href="https://fonts.googleapis.com/css?family=Mr+Dafoe|Sacramento|Tangerine" rel="stylesheet"><link href="https://fonts.googleapis.com/css?family=Yeon+Sung" rel="stylesheet">
<style type="text/css">
</style>
</head>

<body>
<div id="page_background">
  <div id="login_spot">
   <div id="login_form">
    	<a href="deleteForm.jsp"><img src="images/login_4.png" width="45" height="15" /></a>
    	<a href="memberUpdate.html"><img src="images/login_5.png" width="40" height="15" /></a>
    	<a href="#"><img src="images/login_3.png" width="49" height="21" /></a>
    </div>
  </div>
<div id="main_name" style="font-family: 'Tangerine', cursive; font-family: 'Mr Dafoe', cursive; font-family: Sacramento, cursive; font-size: 90px; text-align: center;">Happiness</div>

<div id="page_menu" style="font-family: 'Yeon Sung', cursive;">
    <ul style="list-style-type: none; font-family: 'Yeon Sung', cursive; font-size: 18px;">
        <li style="display:inline"><a href="#">다이어리</a></li>
        <li style="display:inline"><a href="#"> 노트/필기 메모지</a></li>
        <li style="display:inline"><a href="#">파우치/케이스</a></li>
</ul>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  <p>&nbsp;</p>
                   <%
                	int type= Integer.parseInt(request.getParameter("type"));
         			String typeStr="";
         				if(type==1){
         					typeStr="다이어리";
         				}else if(type==2){
         					typeStr="필기";
         				}else if(type==3){
         					typeStr="파우치";
         				}
                	Connection conn = ConnectionProvider.getConnection();
                	List<Product> productList=null;
                	
                	
                	try{
                		ProductDao dao = new ProductDao();
                	productList=dao.selectListType(conn, typeStr);
                		
                		
                		}catch(SQLException e){}
                	finally{JdbcUtil.close(conn);}
               
                %>
                
                
    <div id="productinfo">
      <div id="proentity">
      <c:set var="list" value="<%=productList%>"/>
      <c:forEach var="product" items="${list}">
        <div id="proimg"><a href=#>  
        <a href="productDetail.jsp?productId=${product.productId}">                
                 	<img src="../product/${product.productImage}">
                 	</a> </div>
        
                
             
                 
                 	
						
                 	
                 <div id="prodetail">${product.title}</div>
   
    </c:forEach>
      </div>
    </div>
    </div>
</div>
</body>
</html>
