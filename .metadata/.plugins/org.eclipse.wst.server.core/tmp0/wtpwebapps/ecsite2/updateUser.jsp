<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style" content="text/css"/>
	<meta http-equiv="Content-Script" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta http-equiv="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>ユーザー情報更新画面</title>

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
				height:80px;
				background-color:black;
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
				<h1>更新</h1>
			</div>
			<div>
					<s:if test="message == null">
						<s:form action="UserDetailsAction" >
							<s:param name="id" value="%{id}"/>
							<table border="1">
								<tr>
									<th>ユーザーID</th>
									<td><s:textfield value="#session.loginId"/></td>
								</tr>
								<tr>
									<th>パスワード</th>
									<td><s:textfield value="#session.password"/></td>
								</tr>
								<tr>
									<th>名前</th>
									<td><s:textfield value="#session.userName"/></td>
								</tr>
							</table>
						</s:form>
		<table>
			<tr>
			<!--
				<td>
					<s:form action="DeleteUserDetailsAction">
						<input type="hidden" name="deleteFlg" value="1">
						<s:submit value="削除" method="delete"/>
					</s:form>
				</td>
			-->
				<td>
					<s:form action="UpdateUserDetailsAction">
						<input type="hidden" name="updateFlg" value="1">
						<s:param name="id" value="%{id}"/>
						<s:submit value="更新" method="update"/>
					</s:form>
				</td>
			</tr>
		</table>
					</s:if>

		<s:elseif test="message != null">
			<h3><s:property value="message"/></h3>
		</s:elseif>

				<div id="text-right">
					<p>前画面に戻る場合は<a href='<s:url action="UserListAction"/>'>こちら</a></p>
					<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
				</div>
			</div>
		</div>
		<div id="footer">
		</div>

</body>
</html>