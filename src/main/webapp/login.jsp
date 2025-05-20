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


<nav class="navbar navbar-expand-lg" id="navPrincipal">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">GameLet</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Sobre o Sistema</a>
        </li>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Login</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
        <button class="btn btn-outline-success" type="submit" id="btn-buscar">Buscar</button>
      </form>
    </div>
  </div>
</nav>

 <form class="login-form">
    <h2 class="mb-4 text-center">Login</h2>
    <div class="mb-3">
      <label for="email" class="form-label">Endereço de email</label>
      <input type="email" class="form-control" id="email" placeholder="Seu email" required>
    </div>
    <div class="mb-3">
      <label for="senha" class="form-label">Senha</label>
      <input type="password" class="form-control" id="senha" placeholder="Senha" required>
    </div>
    <button type="submit" class="btn btn-secondary w-100">Entrar</button>
  </form>
  <%@include file="footer.jsp" %>