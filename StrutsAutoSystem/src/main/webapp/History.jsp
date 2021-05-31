<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historyページ</title>
</head>
<body>
    <h1>History</h1>
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
	    <tr>
        	<th>氏名</th>
        	<th>採点</th>
        	<th>採点時間</th>
        </tr>
		<s:iterator value="historylist">
        <tr>
            <td><s:property value="#session.name"/></td>
            <td><s:property value="point"/></td>
            <td><s:property value="created_at"/></td>
        </tr>
    </s:iterator> 
   </table>
   </div>
</body>
</html>