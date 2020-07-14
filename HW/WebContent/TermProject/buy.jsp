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
<style type="text/css">
.event {
	height: 600px;
	width: 1500px;
}
.fir {
	float: left;
	height: 600px;
	width: 500px;
}
.sec {
	height: 600px;
	width: 500px;
}
.sec {
	float: left;
	height: 600px;
	width: 500px;
}
.thi {
	float: left;
	height: 600px;
	width: 500px;
}
.best {
	height: 1620px;
	width: 1500px;
}
.diabe {
	height: 540px;
	width: 1500px;
}
.notbe {
	height: 540px;
	width: 1500px;
}
.poube {
	height: 540px;
	width: 1500px;
}
.diary {
	float: left;
	height: 540px;
	width: 150px;
}
.note {
	float: left;
	height: 540px;
	width: 150px;
}
.pouch {
	float: left;
	height: 540px;
	width: 150px;
}

.sect {
	float: left;
	height: 540px;
	width: 450px;
}
.bottom {
	height: 200px;
	width: 1500px;
	background-color: #9CF;
}
.evengo {
	height: 100px;
	width: 500px;
	margin-top: 500px;
	font-size: 24px;
}
.evenimg {
	float: right;
	height: 500px;
	width: 500px;
	margin-bottom: 100px;
}
.evenimg {
	height: 500px;
	width: 500px;
	margin-bottom: 100px;
}
.bottom {
	background-color: #99F;
	height: 200px;
	width: 1500px;
	font-size: 18px;
}
.detail {
	height: 700px;
	width: 1500px;
}
.detail {
	float: none;
	height: 700px;
	width: 500px;
}
.proimg {
	float: left;
	height: 600px;
	width: 1000px;
}
.product {
	height: 500px;
	width: 500px;
}
.info {
	float: right;
	height: 600px;
	width: 500px;
}
.detail {
	height: 600px;
	width: 500px;
	margin-right: 500px;
	margin-left: 500px;
}
.detailed {
	height: 600px;
	width: 500px;
}
.detailedin {
	float: right;
	height: 600px;
	width: 500px;
}
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
<div id="main_name" style="font-family: 'Tangerine', cursive; font-family: 'Mr Dafoe', cursive; font-family: Sacramento, cursive; font-size: 90px; text-align: center;">Happiness</div>

  <div id="page_menu" style="font-family: 'Yeon Sung', cursive;">
      <ul style="list-style-type: none; font-family: 'Yeon Sung', cursive; font-size: 18px;">
        <li style="display:inline">다이어리</li>
        <li style="display:inline"> 노트/필기 메모지</li>
        <li style="display:inline">파우치/케이스</li>
      </ul>
      <div class="event">
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <div id="gongbaeg"></div>
  <table width="700" border="1" align="center" cellpadding="3" cellspacing="0">
    <tr>
      <th scope="col"><p>상품구매가 완료되었습니다.</p>
        <form id="form3" name="form1" method="post" action="main_login.html">
          <input type="submit" name="login3" id="login3" value="홈페이지로 이동하세요."/>
        </form>
        <p>&nbsp;</p></th>
    </tr>
  </table>
  <p>&nbsp;</p>
</div>
        <%
        	
        	int productId= Integer.parseInt(request.getParameter("productId"));
        	int amount= Integer.parseInt(request.getParameter("amount"));
        	int price= Integer.parseInt(request.getParameter("price"));
        	String option = request.getParameter("option");
        	String userId=(String)session.getAttribute("UI");
       		Buy buy = new Buy(userId, productId,amount, amount*price,new java.util.Date(),option);
        	Connection conn= ConnectionProvider.getConnection();
        	Product product =null;
        	
        	try{
        	
        		BuyDao dao = new BuyDao();
        		dao.insert(conn, buy);
        	}catch(SQLException e) {}
        %>

</body>
</html>