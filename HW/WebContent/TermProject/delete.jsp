<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "my.model.*, my.dao.*, java.sql.*, my.util.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원탈퇴완료</title>
<link href="second.css" rel="stylesheet" type="text/css" /><link href="https://fonts.googleapis.com/css?family=Mr+Dafoe|Sacramento|Tangerine" rel="stylesheet"><link href="https://fonts.googleapis.com/css?family=Yeon+Sung" rel="stylesheet">
</head>

<body>
	        <%
	        	String userId= request.getParameter(("id"));
	        	String password= request.getParameter(("password"));
	        	
	        	Connection conn= ConnectionProvider.getConnection();
				Tmember tmember= null;
	        	try
	        	{
	        		TmemberDao dao = new TmemberDao();
	        		dao.deleteById(conn, userId);
	        	}catch(SQLException e) {}
	        	finally{JdbcUtil.close(conn);}
	        %>
<div id="page_background">
  <div id="login_spot">
    <div id="login_form">
    	<a href="loginForm.html"><img src="images/login_1.png" width="43" height="21" /></a>
    	<a href="signInForm.html"><img src="images/login_2.png" width="61" height="21" /></a>
    	<a href="#"><img src="images/login_3.png" width="49" height="21" /></a></div>
  </div>
  <div id="main_name" style="font-family: 'Tangerine', cursive; font-family: 'Mr Dafoe', cursive; font-family: Sacramento, cursive; font-size: 90px; text-align: center;">Happiness</div>
  <div id="page_menu" style="font-family: 'Yeon Sung', cursive; text-align: center; font-weight: bold;">
  	<ul style="list-style-type: none; font-family: 'Yeon Sung', cursive; font-size: 18px;">
	<li style="display:inline">다이어리</li>
	<li style="display:inline"> 노트/필기 메모지</li>
	<li style="display:inline">파우치/케이스</li>
	</ul>
  	<p>회원탈퇴가 완료되었습니다.
  	</p>
  	<form id="form" name="form" method="post" action="main.html">
  	  <p>* 홈페이지로 이동하시겠습니까?</p>
  	  <p>
  <input type="submit" name="go" id="go" value="홈페이지 이동"/>
      </p>
    </form>
  	<p>&nbsp; </p>
  	<div id="page__line"></div>
  </div>
          <%
    
%>
</div>
</body>
</html>
