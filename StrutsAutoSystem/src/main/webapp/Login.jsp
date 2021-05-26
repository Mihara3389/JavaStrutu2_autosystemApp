<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- タイプ宣言はHTML5のものを使用する -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理システム</title>
<!-- データを入力するとき、placeholderの値を隠します --> 
<script type="text/javascript">
    function eraseInfo(){
        document.getElementByName("name")[0].placeholder="";
        }
</script>
</head>
<body>
    <h1>社員管理システム</h1>
    <br><hr>
    <div align="center">
        <s:form action="login" method="POST" name="form" theme="simple">
            <table>
                <tr>
                    <td><s:text name="ユーザーID"/></td>
                </tr>
                <tr>
                    <td><s:textfield name="name" 
                    placeholder="Emailアドレスを入力してください！"
                    onkeydown="eraseInfo();"/></td>
                </tr>
                <tr><td></td></tr>
                <tr>
                    <td><s:text name="パスワード" /></td>
                </tr>
                <tr>
                    <td><s:password name="password" value="" maxlength="6"/></td>
                </tr>
            </table>
            <s:submit value="ログイン"></s:submit>
        </s:form>
    </div>
    <footer>
        <hr>
        <h4>Softusing.co.jp</h4>
    </footer>
</body>
</html>