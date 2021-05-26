<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topページ</title>
</head>
<body>
    ${param.name}さん、ようこそ。
</body>
</html>
	<div>
		<input type="hidden"  name="action" value="logout" ><br>
		<input type="submit"  value="logout" >
	</div>
	<div>
		<input type="submit"  class ="button" name="list" value="問題と答えを確認・登録する　＞" ><br><br>
		<input type="submit"  class ="button" name="test" value="テストをする　＞"><br><br>
		<input type="submit"  class ="button" name="history" value="過去の採点結果をみる　＞"><br><br>
	</div>
</body>
</html>