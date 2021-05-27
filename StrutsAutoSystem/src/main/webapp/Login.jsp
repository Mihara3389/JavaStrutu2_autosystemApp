<%@ page contentType="text/html; charset=UTF-8"%>
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
    <s:if test="hasActionErrors()">
   		<div style="color:red">
      		<s:actionerror/>
   		</div>
	</s:if>
    <div align="center">
        <s:form action="login" method="POST" name="form" theme="simple">
            <table>
                <tr>
                    <td><s:text name="Username"/></td>
                    <td><s:textfield name="name" 
                    placeholder="ユーザーネーム"
                    maxlength="63"
                    onkeydown="eraseInfo();"/></td>
                </tr>
                <tr>
                    <td><s:text name="Password" /></td>
                    <td><s:password name="password" 
                    placeholder="パスワード"
                    value="" 
                    maxlength="255"/></td>
                </tr>
            </table>
            <br>
            <s:submit value="ログイン"></s:submit>
        </s:form>
    	<br>
    	<s:a href="Signup.jsp">新規登録画面へ</s:a>
    </div>
</body>
</html>