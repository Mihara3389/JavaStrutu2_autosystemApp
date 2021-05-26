<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <h1>ログイン画面</h1>
    <hr>
    <div align="center">
        <s:form action="login" method="POST" name="form" theme="simple">
            <table>
                <tr>
                    <td><s:text name="ユーザーID"/></td>
                    <td><s:textfield name="name" 
                    placeholder="ユーザ名"
                    maxlength="63"
                    onkeydown="eraseInfo();"/></td>
                </tr>
                <tr>
                    <td><s:text name="パスワード" /></td>
                    <td><s:password name="password" 
                    placeholder="パスワード"
                    value="" 
                    maxlength="255"/></td>
                </tr>
            </table>
            <br>
            <s:submit value="ログイン"></s:submit>
        </s:form>
    </div>
</body>
</html>