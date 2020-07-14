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
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	int birth_year = Integer.parseInt(request.getParameter("birth_year"));
	int birth_month = Integer.parseInt(request.getParameter("birth_month"));
	int birth_day = Integer.parseInt(request.getParameter("birth_day"));
	java.util.Date birthDate = new java.util.Date();
	birthDate.setYear(birth_year-1900);
	birthDate.setMonth(birth_month-1);
	birthDate.setDate(birth_day);
	Tmember member = new Tmember (userId, password, name, birthDate);
	Connection conn = ConnectionProvider.getConnection();
	try{
		TmemberDao dao = new TmemberDao();
		dao.insert(conn, member);
	}catch(SQLException e){}
	finally{ JdbcUtil.close(conn); }
%>
<div id="page_background">
  <div id="login_spot">
    <div id="login_form">
    	<a href="loginForm.html"><img src="images/login_1.png" width="43" height="21" /></a>
    	<a href="signInForm.html"><img src="images/login_2.png" width="61" height="21" /></a>
    	<a href="#"><img src="images/login_3.png" width="49" height="21" /></a>
    </div>
  </div>
  <div id="main_name" style="font-family: 'Tangerine', cursive; font-family: 'Mr Dafoe', cursive; font-family: Sacramento, cursive; font-size: 90px; text-align: center;">Happiness</div>
  <div id="page_menu" style="font-family: 'Yeon Sung', cursive;">
    <ul style="list-style-type: none; font-family: 'Yeon Sung', cursive; font-size: 18px;">
      <li style="display:inline">다이어리</li>
      <li style="display:inline"> 노트/필기 메모지</li>
      <li style="display:inline">파우치/케이스</li>
    </ul>
    <div id="page__line"></div>
  </div>
  <div id="gongbaeg"></div>
  <table width="700" border="1" align="center" cellpadding="3" cellspacing="0">
    <tr>
      <th scope="col"><p>회원가입이 완료되었습니다.</p>
        <form id="form3" name="form1" method="post" action="loginForm.html">
          <input type="submit" name="login3" id="login3" value="로그인 페이지로 이동하세요."/>
        </form>
        <p>&nbsp;</p></th>
    </tr>
  </table>
  <p>&nbsp;</p>
</div>
<div id="finsh"></div>
</body>
</html>
