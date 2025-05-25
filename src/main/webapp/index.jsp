<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Jogo"%>
<%@ page import="dao.DaoJogo"%>

<%
HttpSession sessao = request.getSession(false);
boolean logado = (sessao != null && sessao.getAttribute("usuarioLogado") != null);
%>

<div id="EditandoCarrossel">
	<div id="carouselExampleCaptions" class="carousel slide">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://i0.wp.com/www.guiadoed.com.br/wp-content/uploads/2025/01/Marvels-Spider-Man-2-1.webp?fit=1016%2C571&ssl=1"
					class="d-block w-100" alt="homem aranha">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img
					src="https://www.adrenaline.com.br/wp-content/uploads/2024/03/Desenvolvimento-de-GTA-6-esta-atrasado-e-jogo-pode-ser-adiado.jpg"
					class="d-block w-100" alt="GTA">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img
					src="https://static.cdprojektred.com/cms.cdprojektred.com/crystal-news/f783a9404b08a8f2670f4d9d633b483a9c412e20.png"
					class="d-block w-100" alt="the Witcher">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
</div>

<div class="lista-jogos" style="margin-top: 40px;">
	<div class="linha-de-cards"
		style="display: flex; gap: 20px; flex-wrap: wrap;">

		<%
		if (logado) {
		%>
		<div class="card" style="width: 18rem; cursor: pointer;"
			onclick="location.href='listar-jogos'">
			<div class="card-plus-icon">+</div>
			<div class="card-body">
				<h5 class="card-title">Editar Jogos</h5>
				<p class="card-text">Gerencie os jogos cadastrados no sistema.</p>
			</div>
		</div>
		<%
		}
		%>

		<%
		List<Jogo> jogos = DaoJogo.getInstance().getListaDeJogos();
		for (Jogo jogo : jogos) {
		%>
		<div class="card" style="width: 18rem; cursor: pointer;"
			onclick="location.href='VerMais.jsp?id=<%=jogo.getId()%>'">
			<img src="imagens/<%=jogo.getNomeImagem()%>" class="card-img-top"
				alt="<%=jogo.getTitulo()%>">
			<div class="card-body">
				<h5 class="card-title"><%=jogo.getTitulo()%></h5>
				<p class="card-text">R$150,00</p>
			</div>
		</div>
		<%
		}
		%>

	</div>
</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="footer.jsp"%>
