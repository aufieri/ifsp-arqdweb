<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("usuarioLogado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div id="main-content">
	<div class="container" id="container">

		<button type="button" class="btn btn-primary btn-lg"
			id="btn-adicionar" onclick="window.location.href='adicionarjogo.jsp'">Adicionar
			Jogo</button>

		<table class="table" id="tabela">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Titulo</th>
					<th scope="col">Gênero</th>
					<th scope="col">Ano</th>
					<th scope="col">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="jogo" items="${jogos}">
					<tr>
						<th scope="row">${jogo.id}</th>
						<td>${jogo.titulo}</td>
						<td>${jogo.genero}</td>
						<td>${jogo.anoLancamento}</td>
						<td><img src="imagens/highlighter.svg" alt="editar"> <a
							href="excluir?id=${jogo.id}"
							onclick="return confirm('Tem certeza que deseja excluir o jogo?')">
								<img src="imagens/backspace.svg" alt="Excluir">
						</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</div>

<%@include file="footer.jsp"%>
