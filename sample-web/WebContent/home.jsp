<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charaset="UTF-8">
<title>ホーム</title>
      <link rel="stylesheet" type="text/css" href="style.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


  <script>
    $(document).ready(function(){
      $('.abc').bxSlider({
    auto:true,
          mode:'horizontal',
          speed:2000,
          slideWidth:900

      });
    });
  </script>
</head>
<body>
<jsp:include page="header.jsp" />
      <div class="abc">
          <img src="pic3.jpg">
          <img src="pic4.jpg">
          <img src="pic2.jpg">
      </div>

<s:include value="footer.jsp"/>

    </body>
</html>