<%@ page contentType="text/html; charset=UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topページ</title>
</head>
<body>
    <h1>Top</h1>
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
	<div align="center">
            <table>
                <tr>
                    <td><s:form action="list" method="POST" name="form" theme="simple">
						<s:submit value="問題と答えを確認・登録する　＞"/>
					</s:form></td>
                </tr>
                <tr>
                   	<td><s:form action="test" method="POST" name="form" theme="simple">
						<s:submit value="テストをする　＞"/>
					</s:form></td>
                </tr>
                <tr>
                    <td><s:form action="history" method="POST" name="form" theme="simple">
						<s:submit value="過去の採点結果をみる　＞"/>
					</s:form></td>
                </tr>
            </table>
	</div>
</body>
</html>