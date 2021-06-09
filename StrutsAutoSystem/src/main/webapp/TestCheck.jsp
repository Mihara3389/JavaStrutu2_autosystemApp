<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestCheckページ</title>
</head>
<body>
    <h1>TestCheck</h1>
    <p><s:property value="#session.name"/>さん、ようこそ。</p>
    <hr>
    <s:if test="hasActionErrors()">
   		<div style="color:red">
      		<s:actionerror/>
   		</div>
	</s:if>
	<s:form action="logout" method="POST" name="form" theme="simple">
		<s:submit value="ログアウト"></s:submit>
	</s:form>
	<s:form action="top" method="POST" name="form" theme="simple">
		<s:submit value="トップ"></s:submit>
	</s:form>
	<div align="center">
	<s:iterator value="resultlist">
    	<s:property value="#session.name"/>さん<br>
    	<s:property value="total_question"/>問中<s:property value="correct_answer"/>問正解です<br>
    	<s:property value="result"/>点でした。<br>
    	<s:property value="created_at"/>
   	</s:iterator> 
	</div>
	</body>
</html>