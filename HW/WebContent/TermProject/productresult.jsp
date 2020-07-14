<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "my.model.*, my.dao.*, java.sql.*, my.util.*, java.util.*" %>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.awt.Image"%>
<%@page import="com.sun.jimi.core.Jimi"%>
<%@page import="com.sun.jimi.core.JimiException"%>
<%@page import="com.sun.jimi.core.JimiUtils"%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>상품등록</title>
<link href="qnadesign.css" rel="stylesheet" type="text/css">

</head>

<body>

     <div class="page_subimg">
     	<div class="subimgline"></div>
        <div class="subimg">
        	<div id="apDivSubimg"></div>
       </div>
     </div>

  <div class="page_content">
    	<div class="leftmenu">
        
        
        </div>
        <div class="rightcon">
                <img src="images/title2.jpg" width="464" height="58" alt="고객등록">
                <div class="tablestyle">
                <%
            	String uploadPath = "C:\\webb\\ws\\HW\\WebContent\\product\\";
               int maxSize = 1024 * 1024 * 10; // 한번에 올릴 수 있는 파일 용량 : 10M로 제한
               String thumPath = "C:\\webb\\ws\\HW\\WebContent\\productthum\\";
               
               int thumbWidth = 30 ;//썸네일 가로
               int thumbHeight = 44 ;//썸네일 세로
                MultipartRequest multi = null;
                multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
                String title= multi.getParameter("title");
                String maker= multi.getParameter("maker");
                String detail= multi.getParameter("detail");
                int price= Integer.parseInt(multi.getParameter("price"));
                String productType= multi.getParameter("productType");
                String productImage= multi.getOriginalFileName("productImage");
                String fullName="\\ws\\HW\\WebContent\\product\\"+productImage;
                String orgImg=uploadPath+"\\"+productImage;
                String thumbImg=thumPath+"small_"+productImage;
                Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정

                Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성

                Connection conn= ConnectionProvider.getConnection();
                Product product = new Product(title,maker,price,productImage, productType, detail);//객체 생성
                try{
                	ProductDao dao = new ProductDao();
              		dao.insert(conn, product);
                }catch(SQLException e){}
                %>
                
                <%=title%><br>
                <%=maker%><br>
                <%=price%><br>
                <%=productImage%><br>
               <img src="<%=fullName%>">
               <%=detail%><br>
              
               제품 등록이 완료되었습니다.</div>
         </div>
    </div>


</body>
</html>
    