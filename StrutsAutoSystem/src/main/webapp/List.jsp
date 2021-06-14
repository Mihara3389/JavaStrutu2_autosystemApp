<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listページ</title>
</head>
<body>
    <h1>List</h1>
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
	<table>
		<s:iterator value="list">
		<s:if test="%{answer_count==1}">
		<tr>
			<td>問題：</td>
			<td><s:property value="id"/></td>
			<td><s:property value="question"/></td>	<td>
			<s:form action="edit" method="POST" name="form" theme="simple">
				<s:submit value="編集"></s:submit>
				<input type="hidden" name="id" value="id" >
			</s:form>
			</td>
   			<td>
			<s:form action="delete" method="POST" name="form" theme="simple">
				<s:submit value="削除"></s:submit>
				<input type="hidden" name="id" value="id" >
			</s:form>
			</td>
		</tr>
		</s:if>	
   		<tr>
			<td><s:if test="%{answer_count==1}">答え：</s:if></td>
			<td><s:property value="answer_count"/></td>
			<td><s:property value="answer"/></td>
			<td></td>
			<td></td>
		</tr>
    </s:iterator> 
   </table>
   </div>
</body>
</html>