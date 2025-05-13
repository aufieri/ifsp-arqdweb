
<%@include file='header.jsp'%>

<div class="container py-4">
	<h1 class="mb-4">Livros Cadastrados :)</h1>

	<c:if test="${empty livros}">
		<div class="alert alert-info">Nenhum livro cadastrado.</div>
	</c:if>

	<table class="table table-bordered table-hover">
		<thead class="table-dark">
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Gênero</th>
				<th>Ano</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros}">
				<tr>
					<td>${livro.titulo}</td>
					<td>${livro.autor}</td>
					<td>${livro.genero}</td>
					<td>${livro.anoPublicacao}</td>
					<td><a class="btn btn-sm btn-primary"
						href="editar-livro?id=${livro.id}">Editar</a><a
						class="btn btn-sm btn-danger"
						href="excluir-livro?id=${livro.getId()}"
						onclick="return confirm('Deseja realmente excluir este livro?');">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="add.jsp" class="btn btn-success mt-3">Adicionar Livro</a>
</div>

<%@include file='footer.jsp'%>
