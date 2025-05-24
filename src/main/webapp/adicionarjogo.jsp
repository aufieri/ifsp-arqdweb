<%@ include file="header.jsp" %>

<h1 id="TituloCadastro">CADASTRO JOGO</h1>

<form id="Cadastro" action="AddGameServlet" method="post">
  <div class="mb-3">
    <label for="exampleInputJogo" class="form-label">Nome do Jogo</label>
    <input type="text" class="form-control" id="exampleInputJogo" name="titulo">
    <div id="jogoHelp" class="form-text">Adicione o nome do jogo que você quer cadastrar.</div>
  </div>
  
  <div class="mb-3">
    <label for="exampleInputGenero" class="form-label">Gênero</label>
    <input type="text" class="form-control" id="exampleInputGenero" name="genero">
  </div>
  
   <div class="mb-3">
    <label for="exampleInputAno" class="form-label">Ano de Lançamento</label>
    <input type="number" class="form-control" id="exampleInputAno" name="anoLancamento">
  </div>
  
  <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Sinopse do Jogo</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" name="sinopse" rows="3"></textarea>
</div>

<input class="btn btn-primary" type="submit" value="Submit" id="BotaoCadastroJogo">

  </form>

<%@include file="footer.jsp"%>