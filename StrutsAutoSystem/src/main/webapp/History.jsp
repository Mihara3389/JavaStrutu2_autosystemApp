<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historyページ</title>
</head>
<body>
    <h1>History</h1>
    <p> ${param.name}さん、ようこそ。</p>
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
       		<tr th:each="historyList : ${historyList}" >
      			<td th:text="${#authentication.principal.username}"></td>
       			<td th:text="${historyList.point}"></td>
       			<td th:text="${#dates.format(historyList.created_at,'yyyy/MM/dd HH:mm:ss')}"></td>
       		</tr>
        </table>
   </div>
</body>
</html>