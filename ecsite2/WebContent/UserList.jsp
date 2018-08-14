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
		<title>UserList画面</title>

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
				<p>ユーザーリスト</p>
			</div>
			<div>
				<s:if test="userList == null">
					<h3>ユーザー情報はありません。</h3>
				</s:if>
				<s:elseif test="message == null">
					<h3>ユーザーの一覧</h3>
					<table border="1">
					<tr>
						<th>ユーザーID</th>
						<th>パスワード</th>
						<th>名前</th>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td><s:property value="userID"/></td>
							<td><s:property value="password"/></td>
							<td><s:property value="userName"/></td>
						</tr>
					</s:iterator>
					</table>
					<s:form action="UserListAction">
						<input type="hidden" name="deleteFlg" value="1">
						<s:submit value="削除" method="delete"/>
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