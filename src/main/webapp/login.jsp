<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styleLogin.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<title>Login</title>
</head>
<body>

	<%
	Boolean loginErro = (Boolean) request.getAttribute("loginErro");
	String valorUsername = request.getAttribute("username") != null ? (String) request.getAttribute("username") : "";
	%>
	<div class="form-container">
		<form class="login-form" method="post" action="LoginServlet"
			novalidate>
			<h2 class="mb-4 text-center">Login</h2>

			<div class="mb-3">
				<input type="text" name="username" id="username"
					placeholder="Username"
					class="form-control <%=(loginErro != null && loginErro) ? "is-invalid" : ""%>"
					required value="<%=valorUsername%>">
			</div>

			<div class="mb-3">
				<input type="password" name="senha" id="senha" placeholder="Senha"
					class="form-control <%=(loginErro != null && loginErro) ? "is-invalid" : ""%>"
					required>
				<%
				if (loginErro != null && loginErro) {
				%>
				<div class="invalid-feedback">Usuário ou senha incorretos.</div>
				<%
				}
				%>
			</div>

			<button type="submit" class="btn btn-secondary w-100">Entrar</button>
		</form>
	</div>
</body>



<%@ include file="footer.jsp"%>

</body>
</html>
