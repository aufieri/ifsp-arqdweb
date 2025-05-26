<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Jogo"%>
<%@ page import="dao.DaoJogo"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>

<%
HttpSession sessao = request.getSession(false);
boolean logado = (sessao != null && sessao.getAttribute("usuarioLogado") != null);

// Instanciar formatador de moeda brasileira
NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

// Pega somente jogos que são lançamentos
List<Jogo> jogosLancamento = DaoJogo.getInstance().getJogosLancamento();
List<Jogo> jogos = DaoJogo.getInstance().getListaDeJogos();
%>

<h1 id="lancamentos">
  Lançamentos
</h1>
<div id="EditandoCarrossel">
    <div id="carouselExampleCaptions" class="carousel slide">
        <div class="carousel-indicators">
            <% for (int i = 0; i < jogosLancamento.size(); i++) { %>
                <button type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-to="<%= i %>" class="<%= (i == 0) ? "active" : "" %>" 
                    aria-current="<%= (i == 0) ? "true" : "false" %>"
                    aria-label="Slide <%= (i + 1) %>"></button>
            <% } %>
        </div>
        <div class="carousel-inner">
            <% for (int i = 0; i < jogosLancamento.size(); i++) { 
                Jogo jogo = jogosLancamento.get(i);
            %>
            <div class="carousel-item <%= (i == 0) ? "active" : "" %>">
                <img src="imagens/<%= jogo.getNomeImagem() %>" class="d-block w-100" alt="<%= jogo.getTitulo() %>">
            </div>
            <% } %>
        </div>
        <button class="carousel-control-prev" type="button"
            data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span> 
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button"
            data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span> 
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<div class="lista-jogos" style="margin-top: 40px;">
    <h2 style="text-align: center; margin-bottom: 20px; font-family: 'Open Sans', sans-serif; color: black; text-transform: uppercase; letter-spacing: 0.1em;">
        Jogos
    </h2>
    <div class="linha-de-cards" style="display: flex; gap: 20px; flex-wrap: wrap;">
        <% if (logado) { %>
            <div class="card" style="width: 18rem; cursor: pointer;" onclick="location.href='listar-jogos'">
                <div class="card-plus-icon">+</div>
                <div class="card-body">
                    <h5 class="card-title">Editar Jogos</h5>
                    <p class="card-text">Gerencie os jogos cadastrados no sistema.</p>
                </div>
            </div>
        <% } %>

        <% for (Jogo jogo : jogos) { %>
            <div class="card" style="width: 18rem; cursor: pointer;"
                onclick="location.href='VerMais.jsp?id=<%=jogo.getId()%>'">
                <img src="imagens/<%=jogo.getNomeImagem()%>" class="card-img-top" alt="<%=jogo.getTitulo()%>">
                <div class="card-body">
                    <h5 class="card-title"><%=jogo.getTitulo()%></h5>
                    <p class="card-text"><%=formatoMoeda.format(jogo.getPreco())%></p>
                </div>
            </div>
        <% } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="footer.jsp"%>
