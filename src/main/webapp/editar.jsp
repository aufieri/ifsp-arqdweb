<%@ include file="header.jsp"%>

<div id="main-content">
    <h1 id="TituloCadastro">EDITAR JOGO</h1>

    <form id="Cadastro" method="POST" action="UpdateGame" enctype="multipart/form-data">
  
        <input type="hidden" name="id" value="${jogo.id}" />

        <div class="mb-3">
            <label class="form-label">Nome do Jogo</label>
            <input type="text" name="titulo" class="form-control" required value="${jogo.titulo}">
        </div>

        <div class="mb-3">
            <label class="form-label">Desenvolvedor</label>
            <input type="text" name="desenvolvedor" class="form-control" required value="${jogo.desenvolvedor}">
        </div>

        <div class="mb-3">
            <label class="form-label">Ano de Lançamento</label>
            <input type="number" name="anoLancamento" class="form-control" required value="${jogo.anoLancamento}">
        </div>

        <div class="mb-3">
            <label class="form-label">Gênero</label>
            <input type="text" name="genero" class="form-control" required value="${jogo.genero}">
        </div>

        <div class="mb-3">
            <label class="form-label">Sinopse</label>
            <textarea name="sinopse" class="form-control" rows="3" required>${jogo.sinopse}</textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Idioma</label>
            <input type="text" name="idioma" class="form-control" required value="${jogo.idioma}">
        </div>

        <div class="mb-3">
            <label class="form-label">Plataforma</label>
            <input type="text" name="plataforma" class="form-control" required value="${jogo.plataforma}">
        </div>

        <div class="mb-3">
            <label class="form-label">Classificação</label>
            <input type="text" name="classificacao" class="form-control" required value="${jogo.classificacao}">
        </div>

        <div class="mb-3">
            <label class="form-label">Avaliação</label>
            <input type="number" step="0.1" name="avaliacao" class="form-control" required value="${jogo.avaliacao}">
        </div>

        <div class="mb-3">
            <label class="form-label">Imagem do Jogo (atual: ${jogo.imagem})</label>
            <input type="file" name="imagem" class="form-control" accept="image/*">
        </div>

        <input class="btn btn-primary" type="submit" value="Atualizar" id="btn-atualizar-jogo">
    </form>
</div>

<%@ include file="footer.jsp"%>
