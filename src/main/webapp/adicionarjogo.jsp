<%@ include file="header.jsp"%>
<div id="main-content">
	<h1 id="TituloCadastro">CADASTRO JOGO</h1>


	<form id="Cadastro">
		<div class="mb-3">
			<label for="exampleInputJogo" class="form-label">Nome do Jogo</label>
			<input type="text" class="form-control" id="exampleInputJogo"
				aria-describedby="jogoHelp">
			<div id="jogoHelp" class="form-text">Adicione o nome do jogo
				que você quer cadastrar.</div>
		</div>

		<div class="mb-3">
			<label for="exampleInputGenero" class="form-label">Gênero</label> <input
				type="text" class="form-control" id="exampleInputGenero"
				aria-describedby="GenerolHelp">
		</div>

		<div class="mb-3">
			<label for="exampleInputAno" class="form-label">Ano de
				Lançamento</label> <input type="number" class="form-control"
				id="exampleInputAno" aria-describedby="AnoHelp">
		</div>

		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">Sinopse
				do Jogo</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="3"></textarea>
		</div>

		<div class="mb-3">
			<label for="formFileSm" class="form-label">Adicione uma
				Imagem Referente ao Jogo</label> <input class="form-control form-control-sm"
				id="formFileSm" type="file">
		</div>

		<input class="btn btn-primary" type="submit" value="Submit"
			id="BotaoCadastroJogo">

	</form>
</div>



<%@include file="footer.jsp"%>