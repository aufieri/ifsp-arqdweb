<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<div id="main-content">
	<div class="container" id="container">

		<button type="button" class="btn btn-primary btn-lg"
			id="btn-adicionar" onclick="window.location.href='adicionarjogo.jsp'">Adicionar
			Jogo</button>

		<p>Tamanho da lista: ${fn:length(jogos)}</p>
		<table class="table" id="tabela">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Título</th>
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
						<td><img src="imagens/highlighter.svg" alt="editar"> <img
							src="imagens/backspace.svg" alt="Excluir"></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</div>





<%@include file="footer.jsp"%>