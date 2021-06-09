<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testページ</title>
</head>
<body>
    <h1>Test</h1>
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
	<s:form action="testCheck" method="POST" name="form" theme="simple">
	<table>
	<s:iterator value="questionlist">
	   <tr>
			<td><s:property value="id"/><s:hidden name="question_id" value="%{id}"/>
			<td><s:property value="question"/></td>   
		</tr>
    	<tr>
    		<td class=center><label id="title" >回答</label></td>
			<td><s:textfield name="answer" /></td>    
  		</tr>
    </s:iterator> 
	</table>
	<br>
		<s:submit value="Check"/>
	</s:form>
   	</div>
	</body>
</html>