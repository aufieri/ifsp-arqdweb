 <%@ include file="header.jsp" %>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styleLogin.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>


 <form class="login-form" method="post" action="LoginServlet">
    <h2 class="mb-4 text-center">Login</h2>
    <div class="mb-3">
      <label for="username" class="form-label">Username</label>
      <input type="text" name="username" class="form-control" id="username" placeholder="Username" required>
    </div>
    <div class="mb-3">
      <label for="senha" class="form-label">Senha</label>
      <input type="password" name="senha" class="form-control" id="senha" placeholder="Senha" required>
    </div>
    <button type="submit" class="btn btn-secondary w-100">Entrar</button>
  </form>
  <%@include file="footer.jsp" %>