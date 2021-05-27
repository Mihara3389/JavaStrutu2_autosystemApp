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
    <h1>ユーザ登録画面</h1>
    <hr>
    <div align="center">
        <s:form action="signup" method="POST" name="form" theme="simple">
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
            <s:submit value="登録"></s:submit>
        </s:form>
        <br>
        <s:a href="Login.jsp">ログイン画面へ</s:a>
    </div>
</body>
</html>