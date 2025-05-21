<%@include file='header.jsp' %>

<div class="container py-5">
    <h2 class="mb-4">Editar Livro - ${livro.id}</h2>
    <form action="editar-livro" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="id" value="${livro.id}"/>

        <div class="mb-3">
            <label for="titulo" class="form-label">Título</label>
            <input type="text" class="form-control" id="titulo" name="titulo" value="${livro.titulo}" required>
        </div>

        <div class="mb-3">
            <label for="autor" class="form-label">Autor</label>
            <input type="text" class="form-control" id="autor" name="autor" value="${livro.autor}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Gênero</label>
            <c:set var="generoAtual" value="${livro.genero}" />
            <c:forEach var="g" items="${generos}">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="genero" value="${g}"
                        <c:if test="${g eq generoAtual}">checked</c:if>>
                    <label class="form-check-label">${g}</label>
                </div>
            </c:forEach>
        </div>

        <div class="mb-3">
            <label for="anoPublicacao" class="form-label">Ano de Publicação</label>
            <input type="number" class="form-control" id="anoPublicacao" name="anoPublicacao"
                   value="${livro.anoPublicacao}" required>
        </div>

        <button type="submit" class="btn btn-primary">Atualizar</button>
        <a href="listar-livros" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@include file='footer.jsp' %>