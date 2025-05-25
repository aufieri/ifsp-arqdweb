<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado da Busca - Gamelet</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div id="main-content" class="container mt-4">
    <h2>Resultados da busca</h2>

    <%
        // Recupera a lista de jogos da requisição
        java.util.List<model.Jogo> resultados = (java.util.List<model.Jogo>) request.getAttribute("resultados");
        if (resultados == null || resultados.isEmpty()) {
    %>
        <div class="alert alert-warning" role="alert">
            Nenhum jogo encontrado para a busca.
        </div>
    <%
        } else {
    %>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <% for (model.Jogo jogo : resultados) { %>
                <div class="col">
                    <div class="card h-100">
                        <img src="imagens/<%= jogo.getNomeImagem() %>" class="card-img-top" alt="<%= jogo.getTitulo() %>">
                        <div class="card-body">
                            <h5 class="card-title"><%= jogo.getTitulo() %></h5>
                            <p class="card-text"><%= jogo.getSinopse() %></p>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">Avaliação: <%= jogo.getAvaliacao() %> / 5.0</small><br>
                            <a href="detalhesJogo.jsp?id=<%= jogo.getId() %>" class="btn btn-primary btn-sm mt-2" id="btn-vermais">Ver detalhes</a>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    <%
        }
    %>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
