<%@include file='header.jsp' %>

<div class="container py-5">
    <h2 class="mb-4">Adicionar Novo Livro</h2>

    <form action="criar-livro" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="titulo" class="form-label">Título</label>
            <input type="text" class="form-control" id="titulo" name="titulo" required>
        </div>

        <div class="mb-3">
            <label for="autor" class="form-label">Autor</label>
            <input type="text" class="form-control" id="autor" name="autor" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Gênero</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="genero" value="Ficção" required>
                <label class="form-check-label">Ficção</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="genero" value="Não Ficção">
                <label class="form-check-label">Não Ficção</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="genero" value="Fantasia">
                <label class="form-check-label">Fantasia</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="genero" value="Romance">
                <label class="form-check-label">Romance</label>
            </div>
        </div>

        <div class="mb-3">
            <label for="anoPublicacao" class="form-label">Ano de Publicação</label>
            <input type="number" class="form-control" id="anoPublicacao" name="anoPublicacao" required>
        </div>

        <button type="submit" class="btn btn-success">Salvar</button>
        <a href="listar-livros" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<%@include file='footer.jsp' %>