<%@ page import="model.Jogo"%>
<%@ page import="dao.DaoJogo"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<%@ include file="header.jsp"%>

<%
String idParam = request.getParameter("id");
Jogo jogo = null;

if (idParam != null) {
	try {
		int id = Integer.parseInt(idParam);
		jogo = DaoJogo.getInstance().buscarPorId(id);
	} catch (NumberFormatException e) {
		response.sendRedirect("erro.jsp");
	}
}

if (jogo == null) {
	response.sendRedirect("erro.jsp");
}
%>

<div id="main-content">
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6">
				<img src="imagens/<%=jogo.getNomeImagem()%>"
					class="img-fluid img-detalhe-jogo" alt="<%=jogo.getTitulo()%>">
			</div>
			<div class="col-md-6">
				<h2><%=jogo.getTitulo()%></h2>
				<p>
					<strong>Preço:</strong> R$
					<%=String.format("%.2f", jogo.getPreco())%></p>
				<p>
					<strong>Desenvolvedor:</strong>
					<%=jogo.getDesenvolvedor()%></p>
				<p>
					<strong>Ano de Lançamento:</strong>
					<%=jogo.getAnoLancamento()%></p>
				<p>
					<strong>Gênero:</strong>
					<%=jogo.getGenero()%></p>
				<p>
					<strong>Classificação:</strong>
					<%=jogo.getClassificacao()%></p>
				<p>
					<strong>Idioma:</strong>
					<%=jogo.getIdioma()%></p>
				<p>
					<strong>Plataforma:</strong>
					<%=jogo.getPlataforma()%></p>
				<p>
					<strong>Avaliação:</strong>
					<%=jogo.getAvaliacao()%></p>
				<p>
					<strong>Sinopse:</strong>
					<%=jogo.getSinopse()%></p>
				<a href="index.jsp" class="btn btn-secondary mt-3" id="btn-vermais">Voltar</a>
			</div>

		</div>
	</div>
</div>
<!-- FIM DA DIV FLEX -->

<%@ include file="footer.jsp"%>
