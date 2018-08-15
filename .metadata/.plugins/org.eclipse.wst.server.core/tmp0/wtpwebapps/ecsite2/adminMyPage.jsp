<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Style-Type" content="text/css"/>
		<meta http-equiv="Content-Script-Type" content="text/javascript"/>
		<meta http-equiv="imagetoolbar" content="no"/>
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<title>BuyItemConfirm画面</title>

		<style type="text/css">
		/*========TAG LAYOUT========*/
		body{
			margin:o;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		 }

		table{
			text-align:center;
			margin:0 auto;
			}

		/*========ID LAYOUT========*/
		#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
			}

		#header{
			width:100%;
			margin:80px;
			border:black;
			}

		#main{
		width:100%;
		height:500px;
		text-align:center;
			}
		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
			}
		#text-right{
			display:inline-block;
			text-align:right;
			}
	</style>
</head>
<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>AddItem</p>
			</div>
			<div>
				<s:if test="myPageList == null">
					<h3>追加商品はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3>追加商品は以下になります。</h3>
					<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫個数</th>
						<th>追加日</th>
					</tr>
					<s:iterator value="myPageList">
						<tr>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="itemStock"/><span>個</span></td>
							<td><s:property value="insert_date"/></td>
						</tr>
					</s:iterator>
					</table>
					<s:form action="MyPageAction">
						<input type="hidden" name="deleteFlg" value="1">
						<s:submit value="削除" method="delete"/>
					</s:form>

					<s:form action="MyPageAction">
						<input type="hidden" name="createFlg" value="0">
						<s:submit value="追加" method="create"/>
					</s:form>

				</s:elseif>
				<s:if test="message != null">
						<h3><s:property value="message"/></h3>
				</s:if>
				<div id="text-right">
					<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>
</body>
</html>