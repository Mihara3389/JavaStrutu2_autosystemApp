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
	<div align="center">
        <s:form action="top" method="POST" name="form" theme="simple">
            <table>
                <tr>
                    <td><input type="submit"  class ="button" name="list" value="問題と答えを確認・登録する　＞" ></td>
                </tr>
                <tr>
                    <td><input type="submit"  class ="button" name="test" value="テストをする　＞"></td>
                </tr>
                <tr>
                	<td><input type="submit"  class ="button" name="history" value="過去の採点結果をみる　＞"></td>
                </tr>
            </table>
        </s:form>
	</div>
</body>
</html>