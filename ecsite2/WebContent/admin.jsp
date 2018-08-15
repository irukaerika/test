
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
		<title>Admin画面</title>

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

			}
	</style>
</head>
<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>管理者画面</p>
			</div>
	<table>
		<tr>
			<td>
				<s:form action="UserListAction">
					<s:submit value="ユーザー関連"/>
				</s:form>
			</td>
			<td>
				<s:form action="AddItemListAction">
					<s:submit value="商品関連"/>
				</s:form>
			</td>
		</tr>
	</table>
		</div>

		<div id="footer">
		</div>
</body>
</html>