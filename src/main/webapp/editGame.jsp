<%@ include file="header.jsp" %>

<h1 id="TituloCadastro">EDITAR JOGO</h1>

<form id="Editar" action="UpdateGame" method="post">
  
  <input type="hidden" name="id" value="${jogo.id}" />
  
  <div class="mb-3">
    <label for="exampleInputJogo" class="form-label">Nome do Jogo</label>
    <input type="text" name="titulo" class="form-control" id="exampleInputJogo" aria-describedby="jogoHelp" value="${jogo.titulo}">
    <div id="jogoHelp" class="form-text">Edite o nome do jogo.</div>
  </div>
  
  <div class="mb-3">
    <label for="exampleInputGenero" class="form-label">Gênero</label>
    <input type="text" name="genero" class="form-control" id="exampleInputGenero" aria-describedby="GeneroHelp" value="${jogo.genero}">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputAno" class="form-label">Ano de Lançamento</label>
    <input type="number" name="anoLancamento" class="form-control" id="exampleInputAno" aria-describedby="AnoHelp" value="${jogo.anoLancamento}">
  </div>
  
  <div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">Sinopse do Jogo</label>
    <textarea name="sinopse" class="form-control" id="exampleFormControlTextarea1" rows="3">${jogo.sinopse}</textarea>
  </div>
  
  <div class="mb-3">
    <label for="formFileSm" class="form-label">Imagem Referente ao Jogo (opcional)</label>
    <input class="form-control form-control-sm" id="formFileSm" type="file">
  </div>
  
  <input class="btn btn-primary" type="submit" value="Salvar Alterações" id="BotaoEditarJogo">
</form>

<%@ include file="footer.jsp" %>
