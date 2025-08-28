<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập</title>
</head>
<body>
	<h2>Đăng nhập</h2>

	<!-- Hiển thị thông báo lỗi -->
	<c:if test="${not empty alert}">
		<p style="color: red;">${alert}</p>
	</c:if>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="username">Tên đăng nhập:</label><br> <input
			type="text" id="username" name="username" required><br>
		<br> <label for="password">Mật khẩu:</label><br> <input
			type="password" id="password" name="password" required><br>
		<br> <input type="checkbox" name="remember"> Ghi nhớ đăng
		nhập<br>
		<br>

		<button type="submit">Đăng nhập</button>
	</form>
</body>
</html>
