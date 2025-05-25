<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="imagens/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<title>GameLet</title>
</head>
<body>

<%
    String path = request.getServletPath();
    model.Usuario usuario = (model.Usuario) session.getAttribute("usuarioLogado");
%>

<nav class="navbar navbar-expand-lg" id="navPrincipal">
  <div class="container-fluid">
  <img src="imagens/favicon.ico" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
    <a class="navbar-brand" href="index.jsp">Gamelet</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link<%= path.contains("index.jsp") ? " active" : "" %>" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link<%= path.contains("SobreSistema.jsp") ? " active" : "" %>" href="SobreSistema.jsp">Sobre o Sistema</a>
        </li>
      </ul>

        <% if (usuario != null) { %>
          <span class="navbar-text text-white">
            Bem-vindo, <strong><%= usuario.getUserName() %></strong>!
          </span>
          <a class="btn btn-outline-light btn-sm" href="LogoutServlet">Logout</a>
        <% } else { %>
          <a class="nav-link<%= path.contains("login.jsp") ? " active" : "" %>" href="login.jsp">Login</a>
        <% } %>
      </div>
    </div>
</nav>
