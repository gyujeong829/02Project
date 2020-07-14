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
        <%
        	int productId= Integer.parseInt(request.getParameter("productId"));
        	Connection conn= ConnectionProvider.getConnection();
        	Product product= null;
        	try{
        	
        		ProductDao dao = new ProductDao();
        	dao.updateAccessCount(conn, productId);
        	product= dao.selectById(conn, productId);
        	}catch(SQLException e) {}
        	finally{JdbcUtil.close(conn);}
        %>
        <c:set var="product" value="<%=product%>"/>
        <div id="page__line">
          <div class="info">
            <p>&nbsp;</p>
            * 상품명:
            <form id="form1" name="form1" method="post" action="">
              <p>
                <label for="title"></label>
                <input type="text" name="title" value="${product.title}" />
              </p>
            </form>
            * 가격:
            <form id="form2" name="form2" method="post" action="">
              <label for="price"></label>
              <input type="text" name="price" id="price" value="${product.price}" />
            </form>
           <p>*옵션:
                        <label for="option"></label>
                        <select name="option" id="option">
                          <option value="a">a</option>
                          <option value="b">b</option>
                          <option value="c">c</option>
                          <option value="d">d</option>
                          <option value="e">e</option>
                          <option value="f">f</option>
                          <option value="무옵션">무옵션</option>
                        </select>
                      </p>
              <p>*수량:
                        <label for="amount"></label>
                        <select name="amount" id="amount">
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                        </select>
                      </p>
            <input type="button" onclick= "purchase()" value="구매" />
            <p> </form
           >
            </p><input type="text" name="productId" id="productId" value="${product.productId}">
          </div>
          <div class="proimg">

            <div class="product"><img src="../product/${product.productImage}" width="500" height="500" /></div>
          * 상세 정보:<br>
 ${product.detail}
            <form id="form1" name="form1" method="post" action="">
 
 
  
</form>
          </div>
        </div>
        
    </div>
  </div>
</div>
<script type="text/javascript">
	function purchase(){
		var productId=document.getElementById("productId").value.trim();
		var amount = document.getElementById("amount").value.trim();
		var price =	document.getElementById("price").value.trim();
		var option= document.getElementById("option").value.trim();
		location.href='buy.jsp?productId='+productId+'&amount='+amount+'&price='+price+'&option='+option;
	}
	</script>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
